package com.fiap.pagamentos_ms_techchallenge.data.adapter;

import com.fiap.pagamentos_ms_techchallenge.data.service.PaymentStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;



@Component
public class PagamentoStatusAdapter {

    @Autowired
    private PaymentStatusService paymentStatusService;

    @Scheduled(cron = "0 * * * * *") // Cron expression for running every minute
    public void execute() {
        var pagamentos = paymentStatusService.atualizaPagamento();
    }
}
