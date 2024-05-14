package com.fiap.pagamentos_ms_techchallenge.domain.usecases;

import com.fiap.pagamentos_ms_techchallenge.domain.models.PagamentoModel;
import com.fiap.pagamentos_ms_techchallenge.domain.repositories.PagamentoRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PagamentoUseCaseTest {

    @Test
    public void testExecuteSalvar() {

        PagamentoRepository pagamentoRepository = mock(PagamentoRepository.class);

        PagamentoModel pagamentoModel = new PagamentoModel();
        PagamentoUseCase pagamentoUseCase = new PagamentoUseCase(pagamentoRepository);
        when(pagamentoRepository.salvar(pagamentoModel)).thenReturn(pagamentoModel);
        PagamentoModel resultado = pagamentoUseCase.executeSalvar(pagamentoModel);

        verify(pagamentoRepository).salvar(pagamentoModel);
        assertEquals(pagamentoModel, resultado);
    }
}