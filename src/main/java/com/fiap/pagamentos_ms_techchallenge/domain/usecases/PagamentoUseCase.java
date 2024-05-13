package com.fiap.pagamentos_ms_techchallenge.domain.usecases;

import com.fiap.pagamentos_ms_techchallenge.domain.models.PagamentoModel;
import com.fiap.pagamentos_ms_techchallenge.domain.ports.PagamentoUseCasePort;
import com.fiap.pagamentos_ms_techchallenge.domain.repositories.PagamentoRepository;



public class PagamentoUseCase implements PagamentoUseCasePort {

    private final PagamentoRepository pagamentoRepository;

    public PagamentoUseCase(PagamentoRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }


    @Override
    public PagamentoModel executeSalvar(PagamentoModel pagamentoModel) {
        return pagamentoRepository.salvar(pagamentoModel);
    }
}
