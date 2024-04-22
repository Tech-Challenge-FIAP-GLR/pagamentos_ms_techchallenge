package com.fiap.pagamentos_ms_techchallenge.data.adapter;

import com.fiap.pagamentos_ms_techchallenge.domain.models.PagamentoModel;
import com.fiap.pagamentos_ms_techchallenge.domain.repositories.PagamentoRepository;
import org.springframework.stereotype.Component;

@Component
public class PagamentoAdapter implements PagamentoRepository {
    @Override
    public PagamentoModel salvar(PagamentoModel pagamentoModel) {
        return null;
    }
}

