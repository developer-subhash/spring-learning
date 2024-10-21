package com.subhash.spring_test.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
public class AccountControllerUnitTest {
    MockMvc mockMvc;

    @BeforeEach
    void setup() {
        // used for unit test mainly , also need to pass auth credentials
        // this will not do end to end test , if any dependency in controller then it will throw missing dependency
        this.mockMvc = MockMvcBuilders.standaloneSetup(new AccountController()).build();
    }

    @Test
    void getAccounts(){

        try {
            MvcResult mvcResult = mockMvc.perform(get("/getAccounts"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andReturn();

            String response = mvcResult.getResponse().getContentAsString();

            System.out.println(response);;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
