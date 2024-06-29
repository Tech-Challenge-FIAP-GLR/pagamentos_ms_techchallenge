package com.fiap.pagamentos_ms_techchallenge.data.adapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.pagamentos_ms_techchallenge.data.entities.PagamentoEntity;
import com.fiap.pagamentos_ms_techchallenge.data.rabbitmq.PaymentProducer;
import com.fiap.pagamentos_ms_techchallenge.data.service.PaymentStatusService;
import com.fiap.pagamentos_ms_techchallenge.domain.models.PedidoStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class PagamentoStatusAdapter {

    @Autowired
    private PaymentStatusService paymentStatusService;

    @Autowired
    private PaymentProducer paymentProducer;

    @Scheduled(cron = "0 * * * * *") // Cron expression for running every minute
    public void execute() {
        try {
            var pagamentos = paymentStatusService.atualizaPagamento();
            for(PagamentoEntity pagamento : pagamentos){
                String key;
                PedidoStatus body = new PedidoStatus(pagamento.getPedidoId(), pagamento.getDataPagamentoGerado().toString(), pagamento.getDataPagamentoConfirmado().toString(), pagamento.getStatusPagamento());
                if(body.getOrderStatus().equals("PAGO")){
                    key = "success";
                } else{
                    key = "fail";
                }
                String json = new ObjectMapper().writeValueAsString(body);
                paymentProducer.send(json, key);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
