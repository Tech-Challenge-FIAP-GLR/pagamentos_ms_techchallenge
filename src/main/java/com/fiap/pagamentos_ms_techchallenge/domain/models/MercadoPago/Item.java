package com.fiap.pagamentos_ms_techchallenge.domain.models.MercadoPago;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Item {
    private String sku_number;
    private String category;
    private String title;
    private String description;
    private Float unit_price;
    private int quantity;
    private String unit_measure;
    private Float total_amount;
}
