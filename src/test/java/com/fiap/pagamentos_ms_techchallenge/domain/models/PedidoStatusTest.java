package com.fiap.pagamentos_ms_techchallenge.domain.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PedidoStatusTest {

    @Test
    public void testPedidoStatusFullConstructor() {
        String pedidoId = "12345";
        String dataPagamentoGerado = "2023-06-29";
        String dataPagamentoConfirmado = "2023-06-30";
        String orderStatus = "PAGO";

        PedidoStatus pedidoStatus = new PedidoStatus(pedidoId, dataPagamentoGerado, dataPagamentoConfirmado, orderStatus);

        assertEquals(pedidoId, pedidoStatus.getPedidoId());
        assertEquals(dataPagamentoGerado, pedidoStatus.getDataPagamentoGerado());
        assertEquals(dataPagamentoConfirmado, pedidoStatus.getDataPagamentoConfirmado());
        assertEquals(orderStatus, pedidoStatus.getOrderStatus());
    }

    @Test
    public void testPedidoStatusSingleConstructor() {
        String orderStatus = "CANCELADO";

        PedidoStatus pedidoStatus = new PedidoStatus(orderStatus);

        assertEquals(orderStatus, pedidoStatus.getOrderStatus());
        assertNull(pedidoStatus.getPedidoId());
        assertNull(pedidoStatus.getDataPagamentoGerado());
        assertNull(pedidoStatus.getDataPagamentoConfirmado());
    }

    @Test
    public void testSettersAndGetters() {
        PedidoStatus pedidoStatus = new PedidoStatus("12345", "2023-06-29", "2023-06-30", "PAGO");

        pedidoStatus.setPedidoId("54321");
        pedidoStatus.setDataPagamentoGerado("2023-07-01");
        pedidoStatus.setDataPagamentoConfirmado("2023-07-02");
        pedidoStatus.setOrderStatus("CANCELADO");

        assertEquals("54321", pedidoStatus.getPedidoId());
        assertEquals("2023-07-01", pedidoStatus.getDataPagamentoGerado());
        assertEquals("2023-07-02", pedidoStatus.getDataPagamentoConfirmado());
        assertEquals("CANCELADO", pedidoStatus.getOrderStatus());
    }
}