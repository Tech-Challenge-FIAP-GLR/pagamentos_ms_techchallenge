package com.fiap.pagamentos_ms_techchallenge.data.response;

import com.fiap.pagamentos_ms_techchallenge.domain.models.PagamentoModel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class PagamentoResponse {

    private UUID id;
    private String pedidoId;
    private Float total;
    private LocalDateTime dataPagamentoGerado;
    private LocalDateTime dataPagamentoConfirmado;
    private String statusPagamento;
    private String qrCode;

    public PagamentoResponse(UUID id, String pedidoId, Float total, LocalDateTime dataPagamentoGerado, LocalDateTime dataPagamentoConfirmado, String statusPagamento, String qrCode) {
        this.id = id;
        this.pedidoId = pedidoId;
        this.total = total;
        this.dataPagamentoGerado = dataPagamentoGerado;
        this.dataPagamentoConfirmado = dataPagamentoConfirmado;
        this.statusPagamento = statusPagamento;
        this.qrCode = qrCode;
    }

    public static PagamentoResponse fromDomain(PagamentoModel pagamentoModel) {
        return new PagamentoResponse(pagamentoModel.getId(),
                pagamentoModel.getPedidoId(),
                pagamentoModel.getTotal(),
                pagamentoModel.getDataPagamentoGerado(),
                pagamentoModel.getDataPagamentoConfirmado(),
                pagamentoModel.getStatusPagamento(),
                pagamentoModel.getQrCode());
    }
}
