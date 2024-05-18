package com.fiap.pagamentos_ms_techchallenge;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.scheduling.annotation.EnableScheduling;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class PagamentosMsTechchallengeApplicationTests {

    @Test
    void testAnnotations() {
        assertTrue(PagamentosMsTechchallengeApplication.class.isAnnotationPresent(SpringBootApplication.class));
        assertTrue(PagamentosMsTechchallengeApplication.class.isAnnotationPresent(EnableScheduling.class));
    }
}
