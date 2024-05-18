package com.fiap.pagamentos_ms_techchallenge.data.adapter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.pagamentos_ms_techchallenge.data.entities.PagamentoEntity;
import com.fiap.pagamentos_ms_techchallenge.data.repositories.PagamentoJpaRepository;
import com.fiap.pagamentos_ms_techchallenge.domain.enums.PagamentoStatus;
import com.fiap.pagamentos_ms_techchallenge.domain.models.PagamentoModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.*;

@ExtendWith(MockitoExtension.class)
public class PagamentoAdapterTest {

    @Mock
    private PagamentoJpaRepository pagamentoJpaRepository;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private PagamentoAdapter pagamentoAdapter;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        objectMapper = new ObjectMapper();
        pagamentoAdapter = new PagamentoAdapter(pagamentoJpaRepository);
    }

    @Test
    public void testSalvar(){
        PagamentoModel pagamentoModel = new PagamentoModel();
        pagamentoModel.setPedidoId(String.valueOf(1L));
        pagamentoModel.setTotal(100.0F);

        Map<String, String> responseBody = new LinkedHashMap<>();
        responseBody.put("qr_data", "some-qr-code");

        PagamentoEntity pagamentoEntity = new PagamentoEntity();
        pagamentoEntity.setPedidoId(String.valueOf(1L));
        pagamentoEntity.setTotal(100.0F);
        pagamentoEntity.setDataPagamentoGerado(LocalDateTime.now());
        pagamentoEntity.setStatusPagamento(PagamentoStatus.CRIADO.toString());
        pagamentoEntity.setQrCode("some-qr-code");

        when(pagamentoJpaRepository.save(any(PagamentoEntity.class))).thenReturn(pagamentoEntity);

        PagamentoModel result = pagamentoAdapter.salvar(pagamentoModel);

        assertEquals("some-qr-code", result.getQrCode());
        assertEquals(String.valueOf(1L), result.getPedidoId());
        assertEquals(PagamentoStatus.CRIADO.toString(), result.getStatusPagamento());

        verify(pagamentoJpaRepository, times(1)).save(any(PagamentoEntity.class));
    }

    @Test
    public void testListaPagamentosAtivos() {
        PagamentoEntity pagamentoEntity = new PagamentoEntity();
        pagamentoEntity.setPedidoId(String.valueOf(1L));
        pagamentoEntity.setTotal(100.0F);

        when(pagamentoJpaRepository.findAllPagamentosAtivos()).thenReturn(Collections.singletonList(pagamentoEntity));

        List<PagamentoEntity> result = pagamentoAdapter.listaPagamentosAtivos();

        assertEquals(1, result.size());
        assertEquals(String.valueOf(1L), result.get(0).getPedidoId());

        verify(pagamentoJpaRepository, times(1)).findAllPagamentosAtivos();
    }

    @Test
    public void testListaPagamentosAll() {
        PagamentoEntity pagamentoEntity = new PagamentoEntity();
        pagamentoEntity.setPedidoId("aaa");
        pagamentoEntity.setTotal(100.0F);

        when(pagamentoAdapter.listaPagamentosAtivos()).thenReturn(Collections.singletonList(pagamentoEntity));

        List<PagamentoEntity> result = pagamentoAdapter.listaPagamentosAtivos();

        assertEquals(1, result.size());
        assertEquals("aaa", result.get(0).getPedidoId());

        verify(pagamentoJpaRepository, times(1)).findAllPagamentosAtivos();
    }
}
