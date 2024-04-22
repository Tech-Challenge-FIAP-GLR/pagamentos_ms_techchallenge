package com.fiap.pagamentos_ms_techchallenge.domain.ports;

import com.fiap.pagamentos_ms_techchallenge.domain.models.PagamentoModel;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

public interface PagamentoUseCasePort {

    PagamentoModel executeSalvar(PagamentoModel pagamentoModel);
}
