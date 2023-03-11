package com.ali.rabbitmq.producer;

import com.ali.rabbitmq.model.StatusAfterActivateCode;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserMailProducer {

    private final RabbitTemplate rabbitTemplate;


    public void activatedUserAfterStatus(StatusAfterActivateCode statusAfterActivateCode) {
        rabbitTemplate.convertAndSend("exchange-direct-auth", "key-status-setting", statusAfterActivateCode);
    }


}
