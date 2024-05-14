package com.fiap.pagamentos_ms_techchallenge.domain.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fiap.pagamentos_ms_techchallenge.data.entities.PagamentoEntity;
import org.junit.jupiter.api.Test;

public class PagamentoModelTest {

    @Test
    public void testNoArgsConstructor() {
        PagamentoModel pagamentoModel = new PagamentoModel();

        assertNull(pagamentoModel.getId());
        assertNull(pagamentoModel.getPedidoId());
        assertNull(pagamentoModel.getTotal());
        assertNull(pagamentoModel.getDataPagamentoGerado());
        assertNull(pagamentoModel.getDataPagamentoConfirmado());
        assertNull(pagamentoModel.getStatusPagamento());
        assertNull(pagamentoModel.getQrCode());
    }

    @Test
    public void testConstructorWithPedidoIdAndTotal() {
        String pedidoId = "123456";
        Float total = 150.0f;

        PagamentoModel pagamentoModel = new PagamentoModel(pedidoId, total);

        assertNull(pagamentoModel.getId());
        assertEquals(pedidoId, pagamentoModel.getPedidoId());
        assertEquals(total, pagamentoModel.getTotal());
        assertNull(pagamentoModel.getDataPagamentoGerado());
        assertNull(pagamentoModel.getDataPagamentoConfirmado());
        assertNull(pagamentoModel.getStatusPagamento());
        assertNull(pagamentoModel.getQrCode());
    }

    @Test
    public void testConstructorWithAllFields() {
        UUID id = UUID.randomUUID();
        String pedidoId = "123456";
        Float total = 150.0f;
        LocalDateTime dataPagamentoGerado = LocalDateTime.now();
        LocalDateTime dataPagamentoConfirmado = LocalDateTime.now().plusHours(1);
        String statusPagamento = "CRIADO";
        String qrCode = "testQRCode";

        PagamentoModel pagamentoModel = new PagamentoModel(id, pedidoId, total, dataPagamentoGerado, dataPagamentoConfirmado, statusPagamento, qrCode);

        assertEquals(id, pagamentoModel.getId());
        assertEquals(pedidoId, pagamentoModel.getPedidoId());
        assertEquals(total, pagamentoModel.getTotal());
        assertEquals(dataPagamentoGerado, pagamentoModel.getDataPagamentoGerado());
        assertEquals(dataPagamentoConfirmado, pagamentoModel.getDataPagamentoConfirmado());
        assertEquals(statusPagamento, pagamentoModel.getStatusPagamento());
        assertEquals(qrCode, pagamentoModel.getQrCode());
    }

    @Test
    public void testFromEntity() {
        UUID id = UUID.randomUUID();
        String pedidoId = "123456";
        Float total = 150.0f;
        LocalDateTime dataPagamentoGerado = LocalDateTime.now();
        LocalDateTime dataPagamentoConfirmado = LocalDateTime.now().plusHours(1);
        String statusPagamento = "CRIADO";
        String qrCode = "testQRCode";

        PagamentoEntity pagamentoEntity = new PagamentoEntity();
        pagamentoEntity.setId(id);
        pagamentoEntity.setPedidoId(pedidoId);
        pagamentoEntity.setTotal(total);
        pagamentoEntity.setDataPagamentoGerado(dataPagamentoGerado);
        pagamentoEntity.setDataPagamentoConfirmado(dataPagamentoConfirmado);
        pagamentoEntity.setStatusPagamento(statusPagamento);
        pagamentoEntity.setQrCode(qrCode);


        PagamentoModel pagamentoModel = PagamentoModel.fromEntity(pagamentoEntity);

        assertEquals(id, pagamentoModel.getId());
        assertEquals(pedidoId, pagamentoModel.getPedidoId());
        assertEquals(total, pagamentoModel.getTotal());
        assertEquals(dataPagamentoGerado, pagamentoModel.getDataPagamentoGerado());
        assertEquals(dataPagamentoConfirmado, pagamentoModel.getDataPagamentoConfirmado());
        assertEquals(statusPagamento, pagamentoModel.getStatusPagamento());
        assertEquals(qrCode, pagamentoModel.getQrCode());
    }
}
