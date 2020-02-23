package com.example.springoauth2demo.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AuthorizationServerConfigTest {

    @Autowired
    MockMvc mvc;

    @Test
    public void requestTokenWhenUsingClientCredentialsGrantTypeThenOk() throws Exception {
        MockHttpServletRequestBuilder request = post("/oauth/token")
//                .param("grant_type", "client_credentials")
                .param("grant_type", "password")
                .with(httpBasic("foo", "bar"));

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andDo(print());
    }

}