package com.subhash.spring_test.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc // need to  configure mockmvc
@WithMockUser(username = "subhash", roles = {"ADMIN"})
public class AccountControllerEndToEnd {
    @Autowired
    MockMvc mockMvc;


    // getting 401 unauthorized request
    // so add @WithMockUser(username = "user", roles = {"ADMIN"}), work with mockmvc only
    // perform end-to-end test

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
