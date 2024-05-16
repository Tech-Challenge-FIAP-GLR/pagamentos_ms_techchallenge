package com.fiap.pagamentos_ms_techchallenge.data.adapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.pagamentos_ms_techchallenge.data.entities.PagamentoEntity;
import com.fiap.pagamentos_ms_techchallenge.data.repositories.PagamentoJpaRepository;
import com.fiap.pagamentos_ms_techchallenge.domain.enums.PagamentoStatus;
import com.fiap.pagamentos_ms_techchallenge.domain.models.MercadoPago.CashOut;
import com.fiap.pagamentos_ms_techchallenge.domain.models.MercadoPago.Item;
import com.fiap.pagamentos_ms_techchallenge.domain.models.MercadoPago.Root;
import com.fiap.pagamentos_ms_techchallenge.domain.models.PagamentoModel;
import com.fiap.pagamentos_ms_techchallenge.domain.repositories.PagamentoRepository;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.*;

@Component
public class PagamentoAdapter implements PagamentoRepository {

    private final PagamentoJpaRepository pagamentoJpaRepository;

    public PagamentoAdapter(PagamentoJpaRepository pagamentoJpaRepository) {
        this.pagamentoJpaRepository = pagamentoJpaRepository;
    }

    @Override
    public PagamentoModel salvar(PagamentoModel pagamentoModel) {
        String postUrl = "https://api.mercadopago.com/instore/orders/qr/seller/collectors/188752957/pos/TECH001POS001/qrs";

            try {
                RestTemplate restTemplate = new RestTemplate();
                HttpHeaders headers = new HttpHeaders();
                headers.set("Authorization", "Bearer TEST-2069151276901001-041814-bd240ae0107c4144fa0910056d20fa10-188752957");
                headers.setContentType(MediaType.APPLICATION_JSON);

                CashOut cashOut = new CashOut();
                String uuid = UUID.randomUUID().toString();
                Item item = new Item(uuid, "Pedido", "Pedido: " + pagamentoModel.getPedidoId(), "Pedido-" + uuid, pagamentoModel.getTotal(), 1, "unit", pagamentoModel.getTotal());
                ArrayList<Item> itens = new ArrayList<>();
                itens.add(item);
                Root body = new Root(cashOut, item.getDescription(), "reference_12345", itens, item.getTitle(), item.getTotal_amount());
                String json = new ObjectMapper().writeValueAsString(body);
                HttpEntity<String> entity = new HttpEntity<>(json, headers);

                ResponseEntity<?> res = restTemplate.exchange(postUrl, HttpMethod.POST, entity, Object.class);
                String qrCode = ((LinkedHashMap<?, ?>) Objects.requireNonNull(res.getBody())).get("qr_data").toString();

                PagamentoEntity pagamentoEntity = new PagamentoEntity();
                pagamentoEntity.setPedidoId(pagamentoModel.getPedidoId());
                pagamentoEntity.setTotal(pagamentoModel.getTotal());
                pagamentoEntity.setDataPagamentoGerado(LocalDateTime.now());
                pagamentoEntity.setStatusPagamento(PagamentoStatus.CRIADO.toString());
                pagamentoEntity.setQrCode(qrCode);

                var pagamentoRetorno = pagamentoJpaRepository.save(pagamentoEntity);

                pagamentoModel.setId(pagamentoRetorno.getId());
                pagamentoModel.setDataPagamentoGerado(pagamentoRetorno.getDataPagamentoGerado());
                pagamentoModel.setStatusPagamento(pagamentoRetorno.getStatusPagamento());
                pagamentoModel.setQrCode(pagamentoRetorno.getQrCode());



                return pagamentoModel;

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
    }

    @Override
    public List<PagamentoEntity> listaPagamentosAtivos() {
        try{
            var pedidos = pagamentoJpaRepository.findAllPagamentosAtivos();
            return pedidos;

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<PagamentoEntity> listaPagamentosAll() {
        try{
            var pedidos = pagamentoJpaRepository.findAll();
            return pedidos;

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }


}

