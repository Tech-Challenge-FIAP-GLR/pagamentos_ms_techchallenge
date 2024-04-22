package com.fiap.pagamentos_ms_techchallenge.domain.models;

import com.fiap.pagamentos_ms_techchallenge.data.entities.PagamentoEntity;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class PagamentoModel {

    private UUID id;
    private int pedidoId;
    private Float total;
    private LocalDateTime dataPagamentoGerado;
    private LocalDateTime dataPagamentoConfirmado;
    private String statusPagamento;
    private String qrCode;

    public PagamentoModel(UUID id, int pedidoId, Float total, LocalDateTime dataPagamentoGerado, LocalDateTime dataPagamentoConfirmado, String statusPagamento, String qrCode) {
        this.id = id;
        this.pedidoId = pedidoId;
        this.total = total == null ? (float) 0.0 : total;
        this.dataPagamentoGerado = dataPagamentoGerado;
        this.dataPagamentoConfirmado = dataPagamentoConfirmado;
        this.statusPagamento = statusPagamento;
        this.qrCode = qrCode;
    }

    public static PagamentoModel fromEntity(PagamentoEntity pedidoEntity) {
        return new PagamentoModel(pedidoEntity.getId(),
                pedidoEntity.getPedidoId(),
                pedidoEntity.getTotal(),
                pedidoEntity.getDataPagamentoGerado(),
                pedidoEntity.getDataPagamentoConfirmado(),
                pedidoEntity.getStatusPagamento(),
                pedidoEntity.getQrCode());
    }
}
