package com.fiap.pagamentos_ms_techchallenge.data.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.pagamentos_ms_techchallenge.data.request.PagamentoRequest;
import com.fiap.pagamentos_ms_techchallenge.data.response.PagamentoResponse;
import com.fiap.pagamentos_ms_techchallenge.domain.models.PagamentoModel;
import com.fiap.pagamentos_ms_techchallenge.domain.ports.PagamentoUseCasePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@WebMvcTest(PagamentoController.class)
public class PagamentoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PagamentoUseCasePort pagamentoUseCasePort;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCriaPagamento() throws Exception {
        // Arrange
        PagamentoRequest pagamentoRequest = new PagamentoRequest();
        // configure pagamentoRequest with the necessary fields

        PagamentoModel pagamentoDomain = new PagamentoModel();
        // configure pagamentoDomain with the necessary fields

        PagamentoResponse pagamentoResponse = new PagamentoResponse();
        // configure pagamentoResponse with the necessary fields

        when(pagamentoUseCasePort.executeSalvar(any(PagamentoModel.class))).thenReturn(pagamentoDomain);

        // Act & Assert
        mockMvc.perform(post("/api/pagamentos_ms_techchallenge/pagamentos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(pagamentoRequest)))
                .andExpect(status().isOk());
    }
}

