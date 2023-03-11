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
    private String ququeMailCreate = "queque-mail-create";
    private String quqqueStatusSetting = "queque-status-settings";

    private String quqequeStatusSettingsAuth = "quque-status-settings-auth";

    private String keyAuthStatus = "key-status-auth";

    private String keyAuthRegister = "key-auth-register";
    private String keyMailCreate = "key-mail";
    private String keyStatusSetting = "key-status-setting";


    @Bean
    DirectExchange directExchange() {
        return new DirectExchange(directExchange);
    }

    @Bean
    Queue queueAuthRegister() {
        return new Queue(ququeAuthRegister);
    }

    @Bean
    Queue queueSettingStatus() {
        return new Queue(quqqueStatusSetting);
    }

    @Bean
    Queue queueMailCreate() {
        return new Queue(ququeMailCreate);
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

    @Bean
    Binding bindingCreateMail(DirectExchange directExchange, Queue queueMailCreate) {
        return BindingBuilder.bind(queueMailCreate).to(directExchange).with(keyMailCreate);
    }

    @Bean
    Binding bindingStatusSetting(DirectExchange directExchange, Queue queueSettingStatus) {
        return BindingBuilder.bind(queueSettingStatus).to(directExchange).with(keyStatusSetting);
    }
}
