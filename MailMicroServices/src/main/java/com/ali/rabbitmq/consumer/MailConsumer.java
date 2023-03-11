package com.ali.rabbitmq.consumer;

import com.ali.rabbitmq.model.MailCreated;
import com.ali.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailConsumer {

    private final MailService mailService;

    @RabbitListener(queues = "queque-mail-create")
    public void createMailforUser(MailCreated mailCreated) {
        mailService.save(mailCreated);
    }
}
