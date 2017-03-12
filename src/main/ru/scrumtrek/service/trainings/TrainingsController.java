package ru.scrumtrek.service.trainings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.scrumtrek.service.trainings.domain.Training;

import java.util.Iterator;
import java.util.logging.Logger;

/**
 * Created by sergeybaranov on 12/3/17.
 */
@RestController
public class TrainingsController {

    protected Logger logger = Logger.getLogger(TrainingsController.class.getName());

    protected TrainingsRepository trainingsRepository;

    @Autowired
    public TrainingsController(TrainingsRepository trainingsRepository) {
        this.trainingsRepository = trainingsRepository;
    }

    @RequestMapping("/trainings/")
    public Iterable<Training> all() {
        Iterable<Training> trainings = trainingsRepository.findAll();
        for (Training t : trainings) {
            logger.info(t.toString());
        }
        return trainings;
    }

    @RequestMapping("/trainings/{id}")
    public Training byId(@PathVariable("id") Long id) {
        return trainingsRepository.findById(id);
    }



}
