package com.ali.rabbitmq.consumer;

import com.ali.rabbitmq.model.StatusAfterActivateCode;
import com.ali.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserMailConsumer {

    private final UserService userService;

    @RabbitListener(queues = "queque-status-settings")
    public void settingStatusAfterMailActivationCode(StatusAfterActivateCode statusAfterActivateCode) {
        userService.updateStatus(statusAfterActivateCode);
    }
}
