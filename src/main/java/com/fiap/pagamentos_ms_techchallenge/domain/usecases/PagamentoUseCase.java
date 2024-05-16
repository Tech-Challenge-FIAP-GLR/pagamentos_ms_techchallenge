package com.fiap.pagamentos_ms_techchallenge.domain.usecases;

import com.fiap.pagamentos_ms_techchallenge.data.entities.PagamentoEntity;
import com.fiap.pagamentos_ms_techchallenge.domain.models.PagamentoModel;
import com.fiap.pagamentos_ms_techchallenge.domain.ports.PagamentoUseCasePort;
import com.fiap.pagamentos_ms_techchallenge.domain.repositories.PagamentoRepository;

import java.util.List;


public class PagamentoUseCase implements PagamentoUseCasePort {

    private final PagamentoRepository pagamentoRepository;

    public PagamentoUseCase(PagamentoRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }


    @Override
    public PagamentoModel executeSalvar(PagamentoModel pagamentoModel) {
        return pagamentoRepository.salvar(pagamentoModel);
    }

    @Override
    public List<PagamentoEntity> executeListarAtivos() {
        return pagamentoRepository.listaPagamentosAtivos();
    }

    @Override
    public List<PagamentoEntity> executeListarTodos() {
        return pagamentoRepository.listaPagamentosAll();
    }


}
