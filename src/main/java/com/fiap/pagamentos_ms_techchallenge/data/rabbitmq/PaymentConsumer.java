//package com.fiap.pagamentos_ms_techchallenge.data.rabbitmq;
//
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.messaging.handler.annotation.Payload;
//import org.springframework.stereotype.Component;
//
//
//@Component
//public class PaymentConsumer {
//
//    @RabbitListener(queues = {"pagamentos_ms_payment_fail", "pagamentos_ms_pedido_success", "pagamentos_ms_producao_success"})
//    public void receive(@Payload String fileBody) {
//        System.out.println("Message " + fileBody);
//    }
//
//}
