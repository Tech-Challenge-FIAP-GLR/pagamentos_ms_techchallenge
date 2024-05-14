package com.fiap.pagamentos_ms_techchallenge.domain.ports;

import com.fiap.pagamentos_ms_techchallenge.domain.models.PagamentoModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PagamentoUseCasePortTest {

    @Test
    public void testExecuteSalvar() {
        PagamentoModel pagamentoModel = new PagamentoModel();

        PagamentoUseCasePort pagamentoUseCasePort = new PagamentoUseCasePort() {
            @Override
            public PagamentoModel executeSalvar(PagamentoModel pagamentoModel) {
                return pagamentoModel;
            }
        };

        PagamentoModel resultado = pagamentoUseCasePort.executeSalvar(pagamentoModel);

        assertEquals(pagamentoModel, resultado);
    }
}
