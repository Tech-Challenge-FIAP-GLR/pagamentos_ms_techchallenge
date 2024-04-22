package com.fiap.pagamentos_ms_techchallenge.data.repositories;

import com.fiap.pagamentos_ms_techchallenge.data.entities.PagamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoJpaRepository extends JpaRepository<PagamentoEntity, Long> {
    Object findByPedidoId(int pedidoId);
}
