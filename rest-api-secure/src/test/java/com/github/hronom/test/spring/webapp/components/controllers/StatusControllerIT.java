package com.github.hronom.test.spring.webapp.components.controllers;

import com.github.hronom.test.spring.webapp.components.configurations.WebAppConfig;
import com.github.hronom.test.spring.webapp.components.configurations.WebSecurityConfig;

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

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {
    WebSecurityConfig.class, WebAppConfig.class
}, loader = AnnotationConfigWebContextLoader.class)
public class StatusControllerIT {
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
            get("/v1/status").with(
                user("user").password("user").roles("USER")
            )
        ).andDo(
            print()
        ).andExpect(
            status().isOk()
        ).andExpect(
            content().json("{\"status\":true}")
        );
    }

    @Test
    public void testV2() throws Exception {
        mockMvc.perform(get("/v2/status").with(user("admin").password("admin").roles("ADMIN")))
            .andDo(print()).andExpect(status().isOk())
            .andExpect(content().json("{\"status\":true}"));
    }
}
