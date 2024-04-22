package com.fiap.pagamentos_ms_techchallenge.data.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "pagamentos")
public class PagamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "pedido_id")
    private int pedidoId;

    @Column(name = "total")
    private Float total;

    @Column(name = "data_gerado")
    private LocalDateTime dataPagamentoGerado;

    @Column(name = "data_confirmado")
    private LocalDateTime dataPagamentoConfirmado;

    @Column(name = "pagamento_status")
    private String paymentStatus;

    @Column(name = "qr_code")
    private String qrCode;

}
