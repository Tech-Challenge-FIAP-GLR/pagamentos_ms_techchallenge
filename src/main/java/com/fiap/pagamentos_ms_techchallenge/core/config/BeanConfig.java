package com.fiap.pagamentos_ms_techchallenge.core.config;

import com.fiap.pagamentos_ms_techchallenge.domain.ports.PagamentoUseCasePort;
import com.fiap.pagamentos_ms_techchallenge.domain.repositories.PagamentoRepository;
import com.fiap.pagamentos_ms_techchallenge.domain.usecases.PagamentoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public PagamentoUseCasePort pagamentoUseCasePort(PagamentoRepository pagamentoRepository){
        return new PagamentoUseCase(pagamentoRepository);
    }



}
