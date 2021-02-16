package com.lambdaschool.orders.config;

import org.apache.catalina.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

@Configuration
public class H2ServerConfiguration {

    @Value("${h2.tcp.port:9092}")
    private String h2TcPort;

    @Value("${h2.web.port:8082}")
    private String h2WebPort;

    @Bean
    @ConditionalOnExpression("${h2.tcp.enabled:true}")
    public Server h2WebServer() throws
            SQLException
    {
        return Server.createWebServer("-web",
                "-webAllowOthers",
                "-webPort",
                h2WebPort)
                .start();
    }
}
