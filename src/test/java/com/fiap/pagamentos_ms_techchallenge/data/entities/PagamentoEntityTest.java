package com.fiap.pagamentos_ms_techchallenge.data.entities;

import com.fiap.pagamentos_ms_techchallenge.data.repositories.PagamentoJpaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class PagamentoEntityTest {

    @Autowired
    private PagamentoJpaRepository pagamentoJpaRepository;

    @Test
    public void testSaveAndFindById() {
        // Arrange
        PagamentoEntity pagamentoEntity = new PagamentoEntity();
        pagamentoEntity.setPedidoId("123456");
        pagamentoEntity.setTotal(150.0f);
        pagamentoEntity.setDataPagamentoGerado(LocalDateTime.now());
        pagamentoEntity.setStatusPagamento("CRIADO");
        pagamentoEntity.setQrCode("testQRCode");

        // Act
        PagamentoEntity savedEntity = pagamentoJpaRepository.save(pagamentoEntity);

        // Assert
        assertNotNull(savedEntity);
        assertEquals(pagamentoEntity.getId(), savedEntity.getId());
        assertEquals("123456", savedEntity.getPedidoId());
        assertEquals(150.0f, savedEntity.getTotal());
        assertEquals(pagamentoEntity.getDataPagamentoGerado(), savedEntity.getDataPagamentoGerado());
        assertEquals("CRIADO", savedEntity.getStatusPagamento());
        assertEquals("testQRCode", savedEntity.getQrCode());
    }
}
