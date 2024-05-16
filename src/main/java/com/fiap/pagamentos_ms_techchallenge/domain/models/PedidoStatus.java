package com.fiap.pagamentos_ms_techchallenge.domain.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PedidoStatus{

    public PedidoStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @JsonProperty("orderStatus")
    public String getOrderStatus() {
        return this.orderStatus; }
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus; }
    String orderStatus;
}
