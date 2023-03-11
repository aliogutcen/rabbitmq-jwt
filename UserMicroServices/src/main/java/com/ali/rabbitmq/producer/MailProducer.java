package com.ali.rabbitmq.producer;

import com.ali.rabbitmq.model.MailCreated;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailProducer {
    private final RabbitTemplate rabbitTemplate;

    public void mailCreateForActivationCode(MailCreated mailCreated){
        rabbitTemplate.convertAndSend("exchange-direct-auth","key-mail",mailCreated);
    }
}
