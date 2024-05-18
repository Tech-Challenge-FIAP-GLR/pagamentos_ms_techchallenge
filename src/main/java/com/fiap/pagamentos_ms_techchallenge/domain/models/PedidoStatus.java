package com.fiap.pagamentos_ms_techchallenge.domain.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoStatus{

    public PedidoStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @JsonProperty("orderStatus")
    String orderStatus;
}
