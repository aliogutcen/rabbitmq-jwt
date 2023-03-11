package com.ali.config.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    private String directExchange = "exchange-direct-auth";

    private String ququeAuthRegister = "queque-register-auth";
    private String quqequeStatusSettingsAuth = "quque-status-settings-auth";

    private String keyAuthRegister = "key-auth-register";
    private String keyAuthStatus = "key-status-auth";



    @Bean
    DirectExchange directExchange() {
        return new DirectExchange(directExchange);
    }

    @Bean
    Queue queueAuthRegister() {
        return new Queue(ququeAuthRegister);
    }
    @Bean
    Queue queueStatusAuth() {
        return new Queue(quqequeStatusSettingsAuth);
    }

    @Bean
    Binding bindingSettingsStatusAuth(DirectExchange directExchange, Queue queueStatusAuth) {
        return BindingBuilder.bind(queueStatusAuth).to(directExchange).with(keyAuthStatus);
    }


    @Bean
    Binding bindingRegisterAuth(DirectExchange directExchange, Queue queueAuthRegister) {
        return BindingBuilder.bind(queueAuthRegister).to(directExchange).with(keyAuthRegister);
    }

}
