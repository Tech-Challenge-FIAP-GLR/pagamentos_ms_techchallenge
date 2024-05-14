package com.fiap.pagamentos_ms_techchallenge.domain.models.MercadoPago;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CashOutTest {

    @Test
    public void testDefaultConstructor() {
        CashOut cashOut = new CashOut();
        assertEquals(0, cashOut.getAmount());
    }

    @Test
    public void testParameterizedConstructor() {
        int amount = 100;
        CashOut cashOut = new CashOut(amount);
        assertEquals(amount, cashOut.getAmount());
    }

    @Test
    public void testSetAmount() {
        int amount = 50;
        CashOut cashOut = new CashOut();
        cashOut.setAmount(amount);
        assertEquals(amount, cashOut.getAmount());
    }

    @Test
    public void testMockito() {
        int mockedAmount = 75;
        CashOut cashOut = Mockito.mock(CashOut.class);
        Mockito.when(cashOut.getAmount()).thenReturn(mockedAmount);
        assertEquals(mockedAmount, cashOut.getAmount());
    }
}
