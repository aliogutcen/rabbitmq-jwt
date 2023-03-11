package com.ali.rabbitmq.producer;

import com.ali.rabbitmq.model.AuthStatusSettings;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthProducer {

    private final RabbitTemplate rabbitTemplate;

    public void statusSettingsAuth(AuthStatusSettings authStatusSettings) {
        rabbitTemplate.convertAndSend("exchange-direct-auth", "key-status-auth", authStatusSettings);
    }
}
