package com.fiap.pagamentos_ms_techchallenge.data.adapter;

import static org.mockito.Mockito.*;

import com.fiap.pagamentos_ms_techchallenge.data.service.PaymentStatusService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
public class PagamentoStatusAdapterTest {

    @Mock
    private PaymentStatusService paymentStatusService;

    @InjectMocks
    private PagamentoStatusAdapter pagamentoStatusAdapter;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testExecute() {

        when(paymentStatusService.atualizaPagamento()).thenReturn(null);
        pagamentoStatusAdapter.execute();
        verify(paymentStatusService, times(1)).atualizaPagamento();
    }
}

