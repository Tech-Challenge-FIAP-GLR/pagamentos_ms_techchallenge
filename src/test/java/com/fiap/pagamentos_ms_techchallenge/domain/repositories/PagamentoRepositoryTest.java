package com.fiap.pagamentos_ms_techchallenge.domain.repositories;

import com.fiap.pagamentos_ms_techchallenge.data.entities.PagamentoEntity;
import com.fiap.pagamentos_ms_techchallenge.domain.models.PagamentoModel;
import org.junit.jupiter.api.Test;

import java.util.List;

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

            @Override
            public List<PagamentoEntity> listaPagamentosAtivos() {
                return List.of();
            }

            @Override
            public List<PagamentoEntity> listaPagamentosAll() {
                return List.of();
            }
        };

        PagamentoModel resultado = pagamentoRepository.salvar(pagamentoModel);

        assertEquals(pagamentoModel, resultado);
    }
}
