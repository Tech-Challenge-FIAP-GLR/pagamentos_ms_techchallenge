package com.fiap.pagamentos_ms_techchallenge.domain.repositories;

import com.fiap.pagamentos_ms_techchallenge.domain.models.PagamentoModel;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PagamentoRepositoryTest {

    @Test
    public void testSalvar() {
        PagamentoModel pagamentoModel = new PagamentoModel();

        PagamentoRepository pagamentoRepository = new PagamentoRepository() {
            @Override
            public PagamentoModel salvar(PagamentoModel pagamentoModel) {
                return pagamentoModel;
            }
        };

        PagamentoModel resultado = pagamentoRepository.salvar(pagamentoModel);

        assertEquals(pagamentoModel, resultado);
    }
}
