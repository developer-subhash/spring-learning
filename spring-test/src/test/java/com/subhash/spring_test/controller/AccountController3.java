package com.subhash.spring_test.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureWebTestClient
public class AccountController3 {


    // no webtestclient bean found exception, autoconfigure also not working
    @Test
    void exampleTest(@Autowired WebTestClient webClient) {
        webClient
                .get().uri("/getAccounts")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("here are all accounts");
    }

    // unauthorization issue, already bean configured with spring boot test
    @Test
    void exampleTest(@Autowired TestRestTemplate restTemplate) {
        String body = restTemplate.withBasicAuth("user", "533fc695-0de6-43cb-a00c-0fbeb219f39d").getForObject("/getAccounts", String.class);
        assertThat(body).isEqualTo("here are all accounts");
    }
}
