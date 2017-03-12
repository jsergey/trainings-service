package ru.scrumtrek.service.trainings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

@EnableAutoConfiguration
@EnableDiscoveryClient
@Import(ServiceConfiguration.class)
public class TrainingsService {

    @Autowired
    protected TrainingsRepository trainingsRepository;

    public static void main(String[] args) {

        SpringApplication.run(TrainingsService.class, args);


    }

}
