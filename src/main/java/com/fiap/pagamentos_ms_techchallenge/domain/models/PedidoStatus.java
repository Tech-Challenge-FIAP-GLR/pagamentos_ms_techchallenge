package com.fiap.pagamentos_ms_techchallenge.domain.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoStatus{

    public PedidoStatus(String pedidoId, String dataPagamentoGerado, String dataPagamentoConfirmado, String orderStatus) {
        this.orderStatus = orderStatus;
        this.pedidoId = pedidoId;
        this.dataPagamentoGerado = dataPagamentoGerado;
        this.dataPagamentoConfirmado = dataPagamentoConfirmado;
    }

    @JsonProperty("pedidoId")
    String pedidoId;

    @JsonProperty("dataPagamentoGerado")
    String dataPagamentoGerado;

    @JsonProperty("dataPagamentoConfirmado")
    String dataPagamentoConfirmado;

    @JsonProperty("orderStatus")
    String orderStatus;

    public PedidoStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
