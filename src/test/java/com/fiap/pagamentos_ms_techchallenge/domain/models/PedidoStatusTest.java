package com.fiap.pagamentos_ms_techchallenge.domain.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PedidoStatusTest {

    @Test
    public void testPedidoStatusConstructorAndGetter() {
        PedidoStatus pedidoStatus = new PedidoStatus("PAGO");
        assertEquals("PAGO", pedidoStatus.getOrderStatus());
    }

    @Test
    public void testPedidoStatusSetter() {
        PedidoStatus pedidoStatus = new PedidoStatus("PAGO");
        pedidoStatus.setOrderStatus("CANCELADO");
        assertEquals("CANCELADO", pedidoStatus.getOrderStatus());
    }

    @Test
    public void testPedidoStatusSerialization() throws Exception {
        PedidoStatus pedidoStatus = new PedidoStatus("PAGO");
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(pedidoStatus);
        assertEquals("{\"orderStatus\":\"PAGO\"}", json);
    }

}
