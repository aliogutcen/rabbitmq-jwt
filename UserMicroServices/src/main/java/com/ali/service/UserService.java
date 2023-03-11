package com.ali.service;

import com.ali.mapper.IUserMapper;
import com.ali.rabbitmq.model.StatusAfterActivateCode;
import com.ali.rabbitmq.model.UserCreated;
import com.ali.rabbitmq.producer.AuthProducer;
import com.ali.rabbitmq.producer.MailProducer;
import com.ali.repository.IUserRepository;
import com.ali.repository.entity.User;
import com.ali.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService extends ServiceManager<User, Long> {

    private final IUserRepository userRepository;
    private final MailProducer mailProducer;
    private final AuthProducer authProducer;

    public UserService(IUserRepository userRepository, MailProducer mailProducer, AuthProducer authProducer) {
        super(userRepository);
        this.userRepository = userRepository;
        this.mailProducer = mailProducer;
        this.authProducer = authProducer;
    }

    public void save(UserCreated userCreated) {
        User user = IUserMapper.INSTANCE.toUser(userCreated);
        save(user);
        mailProducer.mailCreateForActivationCode(IUserMapper.INSTANCE.toMailCreated(user));
    }

    public void updateStatus(StatusAfterActivateCode statusAfterActivateCode) {
        Optional<User> optionalUser = findById(statusAfterActivateCode.getUserid());
        if (optionalUser.isPresent()) {
            optionalUser.get().setEstatus(statusAfterActivateCode.getEstatus());
            update(optionalUser.get());
            authProducer.statusSettingsAuth(IUserMapper.INSTANCE.toAuthStatusSettings(optionalUser.get()));
        }
    }
}
