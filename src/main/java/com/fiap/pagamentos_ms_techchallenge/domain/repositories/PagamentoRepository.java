package com.fiap.pagamentos_ms_techchallenge.domain.repositories;

import com.fiap.pagamentos_ms_techchallenge.domain.models.PagamentoModel;

public interface PagamentoRepository {

    PagamentoModel salvar(PagamentoModel pagamentoModel);
}
