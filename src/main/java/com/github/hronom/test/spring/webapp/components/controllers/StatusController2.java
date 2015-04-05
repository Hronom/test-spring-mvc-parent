package com.github.hronom.test.spring.webapp.components.controllers;

import com.github.hronom.test.spring.webapp.components.services.MainManager;
import com.github.hronom.test.spring.webapp.pojos.Status;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * Rest controller with "url versioning".
 */
@RestController
public class StatusController2 {
    private static final Logger logger = LogManager.getLogger();

    @Resource(name = "MainManager")
    private MainManager mainManager;

    @RequestMapping(value = "/v1/status", method = {RequestMethod.GET})
    public
    @ResponseBody
    Status statusV1(HttpServletResponse response) {
        Status status = new Status();
        status.setStatus(mainManager.status);
        return status;
    }

    @RequestMapping(value = "/v2/status", method = {RequestMethod.GET})
    public
    @ResponseBody
    Status statusV2(HttpServletResponse response) {
        Status status = new Status();
        status.setStatus(mainManager.status);
        return status;
    }
}