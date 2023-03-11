package com.ali.rabbitmq.consumer;

import com.ali.rabbitmq.model.AuthStatusSettings;
import com.ali.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthConsumer {

    private final AuthService authService;

    @RabbitListener(queues = "quque-status-settings-auth")
    public void settingsStatus(AuthStatusSettings authStatusSettings) {
        authService.settingsStatus(authStatusSettings);
    }
}
