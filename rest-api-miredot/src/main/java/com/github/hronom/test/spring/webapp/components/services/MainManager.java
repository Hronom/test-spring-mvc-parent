package com.github.hronom.test.spring.webapp.components.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;

@Service("MainManager")
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class MainManager {
    public static final String serviceName = "test-spring-mvc";
    private final Logger logger = LogManager.getLogger();

    public String workDirectory;
    public boolean status;

    @Autowired
    public MainManager(ServletContext servletContext) {
//        workDirectory = servletContext.getInitParameter("com.github.hronom.githubwebhooks.dir");
//        if (workDirectory == null) {
//            workDirectory = System.getProperty("user.dir");
//        }
//        logger.info("Created WebAppManager: " + workDirectory);

        status = true;
    }
}