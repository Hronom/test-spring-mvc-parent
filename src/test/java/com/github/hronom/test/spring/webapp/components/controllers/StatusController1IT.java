package com.github.hronom.test.spring.webapp.components.controllers;

import com.github.hronom.test.spring.webapp.components.configurations.WebAppConfig;
import com.github.hronom.test.spring.webapp.components.services.MainManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {WebAppConfig.class}, loader = AnnotationConfigWebContextLoader.class)
public class StatusController1IT {
    private MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testV1() throws Exception {
        mockMvc.perform(
            get("/status").accept("application/" + MainManager.serviceName + ".1.0+json")
                .characterEncoding("UTF-8")
        ).andDo(print()).andExpect(status().isOk()).andExpect(
            content().contentType(
                "application/" + MainManager.serviceName +
                ".1.0+json;charset=UTF-8"
            )
        ).andExpect(content().json("{\"status\":true}"));
    }

    @Test
    public void testV2() throws Exception {
        mockMvc.perform(
            get("/status").accept("application/" + MainManager.serviceName + ".2.0+json")
                .characterEncoding("UTF-8")
        ).andDo(print()).andExpect(status().isOk()).andExpect(
            content().contentType(
                "application/" + MainManager.serviceName +
                ".2.0+json;charset=UTF-8"
            )
        ).andExpect(content().json("{\"status\":true}"));
    }
}
