package com.ds.ds.domain.chatting.config.receiver;

import com.ds.ds.domain.chatting.config.RabbitMqConstants;
import com.ds.ds.domain.chatting.config.receiver.Receiver;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("receiver")
@Configuration
public class ReceiverConfig {
    //Queue 등록
    @Bean
    public Queue queue(){ return new Queue(RabbitMqConstants.ROUTING_KEY); }

    @Bean
    public Binding binding(FanoutExchange exchange, Queue tutorialQueue) {
        return BindingBuilder.bind(tutorialQueue).to(exchange);
    }

    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
                                             MessageListenerAdapter messageListenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(RabbitMqConstants.QUEUE_NAME);
        container.setMessageListener(messageListenerAdapter);
        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(Receiver receiver,
                                           Jackson2JsonMessageConverter jackson2JsonMessageConverter) {
        MessageListenerAdapter messageListenerAdapter = new MessageListenerAdapter(receiver, "receiver");
        messageListenerAdapter.setDefaultListenerMethod("receive");
        messageListenerAdapter.setMessageConverter(jackson2JsonMessageConverter);
        return messageListenerAdapter;
    }

    @Bean
    public Receiver receiver() {
        return new Receiver();
    }

    @Bean
    public Module dateTimeModule(){
        return new JavaTimeModule();
    }
}
