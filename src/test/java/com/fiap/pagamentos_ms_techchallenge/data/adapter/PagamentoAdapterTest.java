package com.fiap.pagamentos_ms_techchallenge.data.adapter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.fiap.pagamentos_ms_techchallenge.data.entities.PagamentoEntity;
import com.fiap.pagamentos_ms_techchallenge.data.repositories.PagamentoJpaRepository;
import com.fiap.pagamentos_ms_techchallenge.domain.enums.PagamentoStatus;
import com.fiap.pagamentos_ms_techchallenge.domain.models.PagamentoModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


public class PagamentoAdapterTest {

    @Mock
    private PagamentoJpaRepository pagamentoJpaRepository;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private PagamentoAdapter pagamentoAdapter;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSalvar() throws Exception {

        PagamentoModel pagamentoModel = new PagamentoModel();
        pagamentoModel.setPedidoId("123");
        pagamentoModel.setTotal(100.0F);

        PagamentoEntity pagamentoEntity = new PagamentoEntity();
        pagamentoEntity.setPedidoId("123");
        pagamentoEntity.setTotal(100.0F);
        pagamentoEntity.setDataPagamentoGerado(LocalDateTime.now());
        pagamentoEntity.setStatusPagamento(PagamentoStatus.CRIADO.toString());
        pagamentoEntity.setQrCode("mockedQRCode");

        when(pagamentoJpaRepository.save(any(PagamentoEntity.class))).thenReturn(pagamentoEntity);


        Map<String, String> responseMap = new HashMap<>();
        responseMap.put("qr_data", "mockedQRCode");
        ResponseEntity<Object> responseEntity = new ResponseEntity<>(responseMap, HttpStatus.OK);

        when(restTemplate.exchange(anyString(), eq(HttpMethod.POST), any(HttpEntity.class), eq(Object.class)))
                .thenReturn(responseEntity);


        PagamentoModel result = pagamentoAdapter.salvar(pagamentoModel);


        assertEquals(pagamentoEntity.getId(), result.getId());
        assertEquals(pagamentoEntity.getDataPagamentoGerado(), result.getDataPagamentoGerado());
        assertEquals(pagamentoEntity.getStatusPagamento(), result.getStatusPagamento());
        assertEquals(pagamentoEntity.getQrCode(), result.getQrCode());
    }
}