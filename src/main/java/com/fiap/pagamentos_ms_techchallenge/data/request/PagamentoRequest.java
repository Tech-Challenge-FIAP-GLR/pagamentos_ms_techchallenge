package com.fiap.pagamentos_ms_techchallenge.data.request;

import com.fiap.pagamentos_ms_techchallenge.domain.models.PagamentoModel;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@Setter
public class PagamentoRequest {

    @NotNull
    private Long pedidoId;

    @NotNull
    private Float total;

    public PagamentoModel toPagamentoDomain(){
        return new PagamentoModel(pedidoId, total);
    }
}
