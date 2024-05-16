package com.fiap.pagamentos_ms_techchallenge.domain.ports;

import com.fiap.pagamentos_ms_techchallenge.data.entities.PagamentoEntity;
import com.fiap.pagamentos_ms_techchallenge.domain.models.PagamentoModel;

import java.util.List;


public interface PagamentoUseCasePort {

    PagamentoModel executeSalvar(PagamentoModel pagamentoModel);

    List<PagamentoEntity> executeListarAtivos();

    List<PagamentoEntity> executeListarTodos();
}
