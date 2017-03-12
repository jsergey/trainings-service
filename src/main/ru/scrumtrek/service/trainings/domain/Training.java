package ru.scrumtrek.service.trainings.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by sergeybaranov on 12/3/17.
 */
@Entity
@Table(name = "Training")
public class Training implements Serializable{

    private static final long serialVersionUID = 1L;

    public static Long nextId = 0L;

    @Id
    protected Long id;

//    private String cost;
//    private Date beginDate;
//    private Date endDate;
    private String trainingName;
    private String trainingDescription;

//    private String trainerName;
//    private String trainerPhoto;
//    private String trainerBio;
//    private String trainerEmail;

    public Training() {
    }

    protected static Long getNextId() {
        synchronized (nextId) {
            return nextId++;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTrainingName() {
        return trainingName;
    }

    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
    }

    public String getTrainingDescription() {
        return trainingDescription;
    }

    public void setTrainingDescription(String trainingDescription) {
        this.trainingDescription = trainingDescription;
    }

    @Override
    public String toString() {
        return "Training{" +
                "id=" + id +
                ", trainingName='" + trainingName + '\'' +
                ", trainingDescription='" + trainingDescription + '\'' +
                '}';
    }
}
