package com.ds.ds.domain.chatting.config;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PubSubConfig {
    @Bean
    public FanoutExchange exchange() {
        return new FanoutExchange(RabbitMqConstants.EXCHANGE_NAME);
    }

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
