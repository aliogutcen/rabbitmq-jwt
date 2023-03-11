package com.ali.service;

import com.ali.config.PasswordEncrypt;
import com.ali.dto.request.AuthLoginRequestDto;
import com.ali.dto.request.AuthRegisterRequestDto;
import com.ali.exception.AuthMicroServiceException;
import com.ali.exception.ErrorType;
import com.ali.mapper.IAuthMapper;
import com.ali.rabbitmq.model.AuthStatusSettings;
import com.ali.rabbitmq.producer.UserProducer;
import com.ali.repository.IAuthRepository;
import com.ali.repository.entity.Auth;
import com.ali.repository.enums.EStatus;
import com.ali.utils.JwtTokenGenerator;
import com.ali.utils.ServiceManager;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Service
public class AuthService extends ServiceManager<Auth, Long> {

    private final IAuthRepository authRepository;
    private final PasswordEncrypt passwordEncrypt;
    private final UserProducer userProducer;
    private final JwtTokenGenerator jwtTokenGenerator;

    public AuthService(IAuthRepository authRepository, PasswordEncrypt passwordEncrypt, UserProducer userProducer, JwtTokenGenerator jwtTokenGenerator) {
        super(authRepository);
        this.authRepository = authRepository;
        this.passwordEncrypt = passwordEncrypt;
        this.userProducer = userProducer;
        this.jwtTokenGenerator = jwtTokenGenerator;
    }

    public Boolean save(AuthRegisterRequestDto authRegisterDto) {
        try {
            Auth auth = IAuthMapper.INSTANCE.toAuthRegisterDto(authRegisterDto);
            byte[] hashPassword = PasswordEncrypt.getSHA(authRegisterDto.getPassword());
            PasswordEncrypt.toHexString(hashPassword);
            auth.setPassword(PasswordEncrypt.toHexString(hashPassword));
            save(auth);
            userProducer.createUser(IAuthMapper.INSTANCE.toUserCreated(auth));
            return true;
        } catch (Exception exception) {
            throw new AuthMicroServiceException(ErrorType.AUTH_NOT_CREATED);
        }
    }

    public Optional<String> login(AuthLoginRequestDto authLoginRequestDto) {
        try {
            byte[] hashPassword = PasswordEncrypt.getSHA(authLoginRequestDto.getPassword());
            String passwordEncrypt = PasswordEncrypt.toHexString(hashPassword);
            Optional<Auth> authOptional = authRepository.findOptionalByUsernameAndPassword(authLoginRequestDto.getUsername(), passwordEncrypt);
            if (authOptional.isEmpty()) throw new AuthMicroServiceException(ErrorType.AUTH_LOGIN_ERROR);
            if (authOptional.get().getEstatus() != EStatus.ACTIVE)
                throw new AuthMicroServiceException(ErrorType.AUTH_NOT_ACTIVE);
            return jwtTokenGenerator.createToken(authOptional.get().getId());
        } catch (NoSuchAlgorithmException e) {
            throw new AuthMicroServiceException(ErrorType.AUTH_LOGIN_ERROR);
        }
    }
    public void settingsStatus(AuthStatusSettings authStatusSettings) {
        Optional<Auth> authOptional = findById(authStatusSettings.getAuthid());
        if (authOptional.isEmpty()) throw new AuthMicroServiceException(ErrorType.AUTH_NOT_FOUND);
        authOptional.get().setEstatus(authStatusSettings.getEstatus());
        update(authOptional.get());
    }
}
