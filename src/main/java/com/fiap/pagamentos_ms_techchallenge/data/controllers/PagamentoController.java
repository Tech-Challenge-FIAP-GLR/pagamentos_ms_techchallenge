package com.fiap.pagamentos_ms_techchallenge.data.controllers;

import com.fiap.pagamentos_ms_techchallenge.data.entities.PagamentoEntity;
import com.fiap.pagamentos_ms_techchallenge.data.request.PagamentoRequest;
import com.fiap.pagamentos_ms_techchallenge.data.response.PagamentoResponse;
import com.fiap.pagamentos_ms_techchallenge.domain.ports.PagamentoUseCasePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Pagamento", description = "API para gerenciamento de pagamentos")
@RestController
@RequestMapping("api/pagamentos_ms_techchallenge/pagamentos")
public class PagamentoController {

    private final PagamentoUseCasePort pagamentoUseCasePort;

    public PagamentoController(PagamentoUseCasePort pagamentoUseCasePort) {
        this.pagamentoUseCasePort = pagamentoUseCasePort;
    }

    @Operation(
            summary = "Cria Pedido",
            description = "Adiciona um pedido ao sistema com os produtos selecionados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @PostMapping
    public ResponseEntity<PagamentoResponse> criaPagamento(@Valid @RequestBody PagamentoRequest pagamentoRequest){
        return ResponseEntity.ok(PagamentoResponse.fromDomain(pagamentoUseCasePort.executeSalvar(pagamentoRequest.toPagamentoDomain())));
    }

    @Operation(
            summary = "Lista Pagamentos TODOS",
            description = "Lista todos os pagamentos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @GetMapping()
    public ResponseEntity<List<PagamentoEntity>> recuperaPedidos(){
        return ResponseEntity.ok(pagamentoUseCasePort.executeListarTodos());
    }

    @Operation(
            summary = "Lista Pagamentos ATIVOS",
            description = "Lista todos os pagamentos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @GetMapping("status/CRIADO")
    public ResponseEntity<List<PagamentoEntity>> recuperaPedidosATIVOS(){
        return ResponseEntity.ok(pagamentoUseCasePort.executeListarAtivos());
    }

}


