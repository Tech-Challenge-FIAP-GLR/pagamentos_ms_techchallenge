package com.fiap.pagamentos_ms_techchallenge;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableRabbit
public class PagamentosMsTechchallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PagamentosMsTechchallengeApplication.class, args);
	}

}
