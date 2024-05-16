package com.fiap.pagamentos_ms_techchallenge.domain.repositories;

import com.fiap.pagamentos_ms_techchallenge.data.entities.PagamentoEntity;
import com.fiap.pagamentos_ms_techchallenge.domain.models.PagamentoModel;

import java.util.List;

public interface PagamentoRepository {

    PagamentoModel salvar(PagamentoModel pagamentoModel);

    List<PagamentoEntity> listaPagamentosAtivos();

    List<PagamentoEntity> listaPagamentosAll();
}
