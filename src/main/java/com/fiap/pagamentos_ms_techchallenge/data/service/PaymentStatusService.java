package com.fiap.pagamentos_ms_techchallenge.data.service;

import com.fiap.pagamentos_ms_techchallenge.data.entities.PagamentoEntity;
import com.fiap.pagamentos_ms_techchallenge.data.repositories.PagamentoJpaRepository;
import com.fiap.pagamentos_ms_techchallenge.domain.enums.PagamentoStatus;
import jakarta.persistence.NoResultException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Service
public class PaymentStatusService {

    private final PagamentoJpaRepository pagamentoJpaRepository;

    public PaymentStatusService(PagamentoJpaRepository pagamentoJpaRepository) {
        this.pagamentoJpaRepository = pagamentoJpaRepository;
    }

    public List<PagamentoEntity> atualizaPagamento() {

        try{

            List<PagamentoEntity> pagamentosAtualizados = new ArrayList<>();
            var pagamentos = pagamentoJpaRepository.findAllPagamentosAtivos();
            Random rand = new Random();

            for(PagamentoEntity pagamento : pagamentos){
                int rand1 = rand.nextInt(100);

                if(rand1 % 5 == 0){
                    pagamento.setStatusPagamento(PagamentoStatus.CANCELADO.toString());
                } else{
                    pagamento.setStatusPagamento(PagamentoStatus.PAGO.toString());
                }

                pagamento.setDataPagamentoConfirmado(LocalDateTime.now());
                pagamentoJpaRepository.save(pagamento);
                pagamentosAtualizados.add(pagamento);
            }
            return pagamentosAtualizados;

        } catch (Exception e) {
            throw new NoResultException();
        }

    }
}
