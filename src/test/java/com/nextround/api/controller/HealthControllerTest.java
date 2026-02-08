package com.nextround.api.controller;

import com.nextround.api.NextRoundApiApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = NextRoundApiApplication.class)
class HealthControllerTest {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private HealthController healthController;

    @Test
    void testHealthEndpoint() {
        Map<String, String> response = healthController.health();
        assertThat(response).isNotNull();
        assertThat(response.get("status")).isEqualTo("UP");
        assertThat(response.get("message")).isEqualTo("NextRound API is running");
    }

    @Test
    void testWelcomeEndpoint() {
        Map<String, String> response = healthController.welcome();
        assertThat(response).isNotNull();
        assertThat(response.get("application")).isEqualTo("NextRound API");
        assertThat(response.get("description")).isEqualTo("Tournament Bracket Generator");
        assertThat(response.get("version")).isEqualTo("0.0.1-SNAPSHOT");
    }
}
