package com.fiap.pagamentos_ms_techchallenge.data.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import com.fiap.pagamentos_ms_techchallenge.data.entities.PagamentoEntity;
import com.fiap.pagamentos_ms_techchallenge.data.repositories.PagamentoJpaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import jakarta.persistence.NoResultException;

@ExtendWith(MockitoExtension.class)
public class PaymentStatusServiceTest {

    @Mock
    private PagamentoJpaRepository pagamentoJpaRepository;

    @InjectMocks
    private PaymentStatusService paymentStatusService;

    private List<PagamentoEntity> pagamentosAtivos;

    @BeforeEach
    public void setUp() {
        pagamentosAtivos = new ArrayList<>();
        PagamentoEntity pagamento = new PagamentoEntity();
        pagamento.setPedidoId("123456");
        pagamento.setTotal(150.0f);
        pagamento.setDataPagamentoGerado(LocalDateTime.now());
        pagamento.setStatusPagamento("CRIADO");
        pagamento.setQrCode("testQRCode");
        pagamentosAtivos.add(pagamento);
    }

    @Test
    public void testAtualizaPagamento() {
        // Arrange
        when(pagamentoJpaRepository.findAllPagamentosAtivos()).thenReturn(pagamentosAtivos);
        when(pagamentoJpaRepository.save(any(PagamentoEntity.class))).thenAnswer(i -> i.getArguments()[0]);

        // Act
        List<PagamentoEntity> result = paymentStatusService.atualizaPagamento();

        // Assert
        assertEquals(1, result.size());
        PagamentoEntity updatedPagamento = result.get(0);
        assertEquals("123456", updatedPagamento.getPedidoId());
        assertEquals(150.0f, updatedPagamento.getTotal());
        assertEquals("testQRCode", updatedPagamento.getQrCode());
        assertEquals(LocalDateTime.now().getYear(), updatedPagamento.getDataPagamentoConfirmado().getYear());
        assertEquals(LocalDateTime.now().getMonth(), updatedPagamento.getDataPagamentoConfirmado().getMonth());
        assertEquals(LocalDateTime.now().getDayOfMonth(), updatedPagamento.getDataPagamentoConfirmado().getDayOfMonth());
        verify(pagamentoJpaRepository, times(1)).findAllPagamentosAtivos();
        verify(pagamentoJpaRepository, times(1)).save(any(PagamentoEntity.class));
    }

    @Test
    public void testAtualizaPagamento_Exception() {
        // Arrange
        when(pagamentoJpaRepository.findAllPagamentosAtivos()).thenThrow(new NoResultException());

        // Act & Assert
        assertThrows(NoResultException.class, () -> paymentStatusService.atualizaPagamento());
        verify(pagamentoJpaRepository, times(1)).findAllPagamentosAtivos();
    }
}