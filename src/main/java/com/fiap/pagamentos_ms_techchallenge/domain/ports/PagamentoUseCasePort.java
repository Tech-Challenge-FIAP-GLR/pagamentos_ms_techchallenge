package com.fiap.pagamentos_ms_techchallenge.domain.ports;

import com.fiap.pagamentos_ms_techchallenge.domain.models.PagamentoModel;


public interface PagamentoUseCasePort {

    PagamentoModel executeSalvar(PagamentoModel pagamentoModel);
}
