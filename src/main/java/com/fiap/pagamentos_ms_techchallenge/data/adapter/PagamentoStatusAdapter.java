package com.fiap.pagamentos_ms_techchallenge.data.adapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.pagamentos_ms_techchallenge.data.entities.PagamentoEntity;
import com.fiap.pagamentos_ms_techchallenge.data.service.PaymentStatusService;
import com.fiap.pagamentos_ms_techchallenge.domain.models.PedidoStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class PagamentoStatusAdapter {

    @Autowired
    private PaymentStatusService paymentStatusService;

    @Scheduled(cron = "0 * * * * *") // Cron expression for running every minute
    public void execute() {
        var pagamentos = paymentStatusService.atualizaPagamento();
        String putUrl = "http://pedidos-ms-app:3000/api/pedidos/";
        try {

            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer TEST-2069151276901001-041814-bd240ae0107c4144fa0910056d20fa10-188752957");
            headers.setContentType(MediaType.APPLICATION_JSON);

            for(PagamentoEntity pagamento : pagamentos){
                PedidoStatus body = new PedidoStatus(pagamento.getStatusPagamento());
                String putUrlFinal = putUrl+pagamento.getPedidoId();
                String json = new ObjectMapper().writeValueAsString(body);
                HttpEntity<String> entity = new HttpEntity<>(json, headers);
                ResponseEntity<?> res = restTemplate.exchange(putUrlFinal, HttpMethod.PUT, entity, Object.class);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
