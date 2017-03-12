package ru.scrumtrek.service.trainings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

/**
 * Created by sergeybaranov on 12/3/17.
 */
@EnableAutoConfiguration
@EnableDiscoveryClient
@Import(ServiceConfiguration.class)
public class TrainingsService {

    @Autowired
    protected TrainingsRepository trainingsRepository;

    public static void main(String[] args) {

        System.setProperty("spring.config.name", "trainings-service");
        SpringApplication.run(TrainingsService.class, args);


    }

}
