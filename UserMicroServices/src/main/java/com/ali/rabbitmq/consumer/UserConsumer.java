package com.ali.rabbitmq.consumer;

import com.ali.rabbitmq.model.UserCreated;
import com.ali.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserConsumer {
    private final UserService userService;
    @RabbitListener(queues = "queque-register-auth")
    public void createUser(UserCreated userCreated) {
        userService.save(userCreated);
    }
}
