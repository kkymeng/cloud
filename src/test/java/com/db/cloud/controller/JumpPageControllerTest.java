package com.db.cloud.controller;

import com.db.cloud.CloudApplicationTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertFalse;


/**
 * @author yunkk
 * @description
 */
@SpringBootTest
@AutoConfigureMockMvc
class JumpPageControllerTest extends CloudApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Test
    void getAdderByCode() throws Exception {
        String result = mvc.perform(MockMvcRequestBuilders.post("/navigation/getAddr")
                .param("adderCode","2"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString(); // 对返回的状态进行判断
        assertFalse(result.isEmpty());
    }

    @Test
    void getAllAddr() throws Exception {
        String result = mvc.perform(MockMvcRequestBuilders.get("/navigation/getAllAddr"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();;
        assertFalse(result.isEmpty());
    }

    @Test
    void getRoundAddr()throws Exception {
        String result = mvc.perform(MockMvcRequestBuilders.get("/navigation/getRoundAddr"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();;
        assertFalse(result.isEmpty());
    }
}