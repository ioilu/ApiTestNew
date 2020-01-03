package com.yzw.apitest.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class DBConfig {

    @Value("${db.url}")
    private String MYSQL_URL;

    @Value("${db.username}")
    private String MYSQL_USERNAME;

    @Value("${db.password}")
    private String MYSQL_PASSWORD;

}
