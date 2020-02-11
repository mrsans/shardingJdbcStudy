package com.sans.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShardingControllerTest {

    private MockMvc mockMvc;

    private MockHttpSession session;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();   //构造MockMvc
        session = new MockHttpSession();
    }

    @Test
    public void insert () throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/insert")
                .param("nId", "1223")
                .param("cName", "haha")
                .param("cPlace", "赤峰")
                .param("nSex", "1")
                .param("nCard", "1293798")
                .contentType(MediaType.MULTIPART_FORM_DATA_VALUE))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void insertShardingLevel () throws Exception{
        for (int i=0; i < 100; i++)
            this.mockMvc.perform(MockMvcRequestBuilders
                .get("/insertLevel")
                .param("cName", "haha")
                .param("cPlace", "赤峰")
                .param("nSex", "1")
                .param("nCard", String.valueOf(11237329171L))
                .contentType(MediaType.MULTIPART_FORM_DATA_VALUE))
                .andDo(MockMvcResultHandlers.print());
        for (int i=0; i < 100; i++)
            this.mockMvc.perform(MockMvcRequestBuilders
                    .get("/insertLevel")
                    .param("cName", "haha")
                    .param("cPlace", "赤峰")
                    .param("nSex", "1")
                    .param("nCard", String.valueOf(11237329172L))
                    .contentType(MediaType.MULTIPART_FORM_DATA_VALUE))
                    .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void selectAllDatas() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/selectAllDatas"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void insertCourse() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/insertCourse")
            .param("nId", String.valueOf(new Random().nextLong()))
            .param("cName", "2222"))
            .andDo(MockMvcResultHandlers.print());
    }
}
