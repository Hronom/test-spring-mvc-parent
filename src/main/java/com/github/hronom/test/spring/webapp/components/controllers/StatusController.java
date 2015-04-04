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

@RestController
@RequestMapping(value = "/status", method = {RequestMethod.GET})
public class StatusController {
    private static final Logger logger = LogManager.getLogger();

    @Resource(name = "MainManager")
    private MainManager mainManager;

    @RequestMapping(headers = {
        "accept=application/" + MainManager.serviceName + ".1.0+json;charset=UTF-8"
    })
    public
    @ResponseBody
    Status status1(
        @RequestHeader("Accept") String accept, HttpServletResponse response
    ) {
        logger.debug(accept);
        Status status = new Status();
        status.setStatus(mainManager.status);
        return status;
    }

    @RequestMapping(headers = {
        "accept=application/" + MainManager.serviceName + ".2.0+json;charset=UTF-8"
    })
    public
    @ResponseBody
    Status status2(
        @RequestHeader("Accept") String accept, HttpServletResponse response
    ) {
        logger.debug(accept);
        Status status = new Status();
        status.setStatus(mainManager.status);
        return status;
    }
}
