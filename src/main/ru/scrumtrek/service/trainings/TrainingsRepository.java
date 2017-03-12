package ru.scrumtrek.service.trainings;

import org.springframework.data.repository.Repository;
import ru.scrumtrek.service.trainings.domain.Training;

/**
 * Created by sergeybaranov on 12/3/17.
 */
public interface TrainingsRepository extends Repository<Training, Long>{

    Training findById(Long id);

    Iterable<Training> findAll();

}
