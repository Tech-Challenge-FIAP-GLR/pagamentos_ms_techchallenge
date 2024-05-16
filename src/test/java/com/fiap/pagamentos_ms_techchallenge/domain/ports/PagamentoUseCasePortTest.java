package com.fiap.pagamentos_ms_techchallenge.domain.ports;

import com.fiap.pagamentos_ms_techchallenge.data.entities.PagamentoEntity;
import com.fiap.pagamentos_ms_techchallenge.domain.models.PagamentoModel;
import org.junit.jupiter.api.Test;

import java.util.List;

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

            @Override
            public List<PagamentoEntity> executeListarAtivos() {
                return List.of();
            }

            @Override
            public List<PagamentoEntity> executeListarTodos() {
                return List.of();
            }
        };

        PagamentoModel resultado = pagamentoUseCasePort.executeSalvar(pagamentoModel);

        assertEquals(pagamentoModel, resultado);
    }
}
