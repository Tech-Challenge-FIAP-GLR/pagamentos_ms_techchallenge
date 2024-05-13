package com.fiap.pagamentos_ms_techchallenge.data.repositories;

import com.fiap.pagamentos_ms_techchallenge.data.entities.PagamentoEntity;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Hidden
public interface PagamentoJpaRepository extends JpaRepository<PagamentoEntity, Long> {
    Object findByPedidoId(String pedidoId);


    @Query(
            value = "SELECT * FROM techchallenge_pagamentos.pagamentos where pagamento_status like 'CRIADO' order by data_gerado;",
            nativeQuery = true)
    List<PagamentoEntity> findAllPagamentosAtivos();
}
