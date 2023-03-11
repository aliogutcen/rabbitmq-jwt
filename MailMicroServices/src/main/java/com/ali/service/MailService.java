package com.ali.service;

import com.ali.dto.request.ActivatedCode;
import com.ali.mapper.IMailMapper;
import com.ali.rabbitmq.model.MailCreated;
import com.ali.rabbitmq.producer.UserMailProducer;
import com.ali.repository.IMailRepository;
import com.ali.repository.entity.Mail;
import com.ali.repository.enums.EStatus;
import com.ali.utility.ActivateCodeGenerator;
import com.ali.utility.ServiceManager;
import com.ali.exception.ErrorType;
import com.ali.exception.MailMicroServiceException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MailService extends ServiceManager<Mail, Long> {
    private final IMailRepository mailRepository;
    private final MailSenderService mailSenderService;
    private final UserMailProducer userMailProducer;

    public MailService(IMailRepository mailRepository, MailSenderService mailSenderService, UserMailProducer userMailProducer) {
        super(mailRepository);
        this.mailRepository = mailRepository;
        this.mailSenderService = mailSenderService;
        this.userMailProducer = userMailProducer;

    }

    public void save(MailCreated mailCreated) {
        Mail mail = IMailMapper.INSTANCE.toMail(mailCreated);
        mail.setCode(ActivateCodeGenerator.generateCode());
        save(mail);
        mailSenderService.sendMail(mail);
    }

    public Boolean activateCode(ActivatedCode activatedCode) {
        Optional<Mail> mailOptional = mailRepository.findOptionalByMailAndCode(activatedCode.getMail(), activatedCode.getCode());
        if (mailOptional.isEmpty()) throw new MailMicroServiceException(ErrorType.TOKEN_ERROR);
        mailOptional.get().setEstatus(EStatus.ACTIVE);
        update(mailOptional.get());
        userMailProducer.activatedUserAfterStatus(IMailMapper.INSTANCE.toStatusAfterActivateCode(mailOptional.get()));
        return true;
    }
}
