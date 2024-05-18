package com.fiap.pagamentos_ms_techchallenge.domain.usecases;

import com.fiap.pagamentos_ms_techchallenge.data.entities.PagamentoEntity;
import com.fiap.pagamentos_ms_techchallenge.domain.models.PagamentoModel;
import com.fiap.pagamentos_ms_techchallenge.domain.repositories.PagamentoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PagamentoUseCaseTest {

    @Mock
    private PagamentoRepository pagamentoRepository;

    @InjectMocks
    private PagamentoUseCase pagamentoUseCase;

    private PagamentoModel pagamentoModel;
    private PagamentoEntity pagamentoEntity;

    @BeforeEach
    public void setUp() {
        pagamentoModel = new PagamentoModel();
        pagamentoModel.setPedidoId("uuid");
        pagamentoModel.setTotal(100.0F);

        pagamentoEntity = new PagamentoEntity();
        pagamentoEntity.setPedidoId("uuid");
        pagamentoEntity.setTotal(100.0F);
    }

    @Test
    public void testExecuteSalvar() {
        when(pagamentoRepository.salvar(any(PagamentoModel.class))).thenReturn(pagamentoModel);

        PagamentoModel result = pagamentoUseCase.executeSalvar(pagamentoModel);

        assertEquals(pagamentoModel, result);
        verify(pagamentoRepository, times(1)).salvar(any(PagamentoModel.class));
    }

    @Test
    public void testExecuteListarAtivos() {
        when(pagamentoRepository.listaPagamentosAtivos()).thenReturn(Collections.singletonList(pagamentoEntity));

        List<PagamentoEntity> result = pagamentoUseCase.executeListarAtivos();

        assertEquals(1, result.size());
        assertEquals(pagamentoEntity, result.get(0));
        verify(pagamentoRepository, times(1)).listaPagamentosAtivos();
    }

    @Test
    public void testExecuteListarTodos() {
        when(pagamentoRepository.listaPagamentosAll()).thenReturn(Collections.singletonList(pagamentoEntity));

        List<PagamentoEntity> result = pagamentoUseCase.executeListarTodos();

        assertEquals(1, result.size());
        assertEquals(pagamentoEntity, result.get(0));
        verify(pagamentoRepository, times(1)).listaPagamentosAll();
    }
}