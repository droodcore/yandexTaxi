package ru.mk.yandextaxi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableFeignClients
@ConfigurationProperties
@SpringBootApplication
public class YandexTaxiApplication {

    public static void main(String[] args) {
        SpringApplication.run(YandexTaxiApplication.class, args);
    }

}
