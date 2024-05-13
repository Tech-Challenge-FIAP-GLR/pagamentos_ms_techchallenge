package com.fiap.pagamentos_ms_techchallenge.domain.enums;

import lombok.Getter;

@Getter
public enum PagamentoStatus {

    CRIADO(1),
    PAGO(2),
    CANCELADO(3);


    final int code;

    PagamentoStatus(int code) {
        this.code = code;
    }

    public static PagamentoStatus valueOf(int code) {
        for (PagamentoStatus value : PagamentoStatus.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid payment status code");
    }


}
