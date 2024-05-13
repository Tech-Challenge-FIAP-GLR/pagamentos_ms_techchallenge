package com.fiap.pagamentos_ms_techchallenge.domain.models.MercadoPago;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CashOut {

    private int amount;

    public CashOut() {
        this.amount = 0;
    }
}


