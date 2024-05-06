package com.fiap.pagamentos_ms_techchallenge.domain.models.MercadoPago;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
public class Root {
    private CashOut cash_out;
    private String description;
    private String external_reference;
    private ArrayList<Item> items;
    private String title;
    private Float total_amount;
}
