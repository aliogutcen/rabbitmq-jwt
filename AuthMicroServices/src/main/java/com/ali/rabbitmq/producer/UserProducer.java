package com.ali.rabbitmq.producer;

import com.ali.rabbitmq.model.UserCreated;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserProducer {

    private final RabbitTemplate rabbitTemplate;

    public void createUser(UserCreated userCreated) {
        rabbitTemplate.convertAndSend("exchange-direct-auth", "key-auth-register", userCreated);
    }
}
