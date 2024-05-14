package com.fiap.pagamentos_ms_techchallenge.domain.enums;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class PagamentoStatusTest {

    @Test
    public void testValueOf_ValidCode() {
        assertEquals(PagamentoStatus.CRIADO, PagamentoStatus.valueOf(1));
        assertEquals(1, PagamentoStatus.CRIADO.getCode());

        assertEquals(PagamentoStatus.PAGO, PagamentoStatus.valueOf(2));
        assertEquals(2, PagamentoStatus.PAGO.getCode());

        assertEquals(PagamentoStatus.CANCELADO, PagamentoStatus.valueOf(3));
        assertEquals(3, PagamentoStatus.CANCELADO.getCode());
    }

    @Test
    public void testValueOf_InvalidCode() {
        assertThrows(IllegalArgumentException.class, () -> PagamentoStatus.valueOf(0));
        assertThrows(IllegalArgumentException.class, () -> PagamentoStatus.valueOf(4));
    }
}
