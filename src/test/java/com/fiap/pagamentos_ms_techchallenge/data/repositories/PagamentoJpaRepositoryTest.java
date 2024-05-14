package com.fiap.pagamentos_ms_techchallenge.data.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import java.util.List;

import com.fiap.pagamentos_ms_techchallenge.data.entities.PagamentoEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DataJpaTest
@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PagamentoJpaRepositoryTest {

    @Autowired
    private PagamentoJpaRepository pagamentoJpaRepository;

    private PagamentoEntity pagamentoEntity;

    @BeforeEach
    public void setUp() {
        pagamentoEntity = new PagamentoEntity();
        pagamentoEntity.setPedidoId("123456");
        pagamentoEntity.setTotal(150.0f);
        pagamentoEntity.setDataPagamentoGerado(LocalDateTime.now());
        pagamentoEntity.setStatusPagamento("CRIADO");
        pagamentoEntity.setQrCode("testQRCode");
        pagamentoJpaRepository.save(pagamentoEntity);
    }

    @Test
    public void testFindByPedidoId() {

        Object foundEntity = pagamentoJpaRepository.findByPedidoId("123456");

        assertNotNull(foundEntity);
        if (foundEntity instanceof PagamentoEntity) {
            PagamentoEntity pagamento = (PagamentoEntity) foundEntity;
            assertEquals("123456", pagamento.getPedidoId());
            assertEquals(150.0f, pagamento.getTotal());
        }
    }

    @Test
    public void testFindAllPagamentosAtivos() {

        List<PagamentoEntity> pagamentosAtivos = pagamentoJpaRepository.findAllPagamentosAtivos();

        assertNotNull(pagamentosAtivos);
        assertEquals(1, pagamentosAtivos.size());
        PagamentoEntity pagamento = pagamentosAtivos.get(0);
        assertEquals("123456", pagamento.getPedidoId());
        assertEquals("CRIADO", pagamento.getStatusPagamento());
    }
}
