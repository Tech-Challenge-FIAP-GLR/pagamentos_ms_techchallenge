package com.fiap.pagamentos_ms_techchallenge.data.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String message, String key) {
        rabbitTemplate.convertAndSend("pagamentos_ms_exchange", key, message);
    }

}
