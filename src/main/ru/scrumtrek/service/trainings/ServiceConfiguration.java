package ru.scrumtrek.service.trainings;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by sergeybaranov on 12/3/17.
 */
@Configuration
@ComponentScan
@EntityScan("ru.scrumtrek.service.trainings.domain")
@EnableJpaRepositories("ru.scrumtrek.service.trainings")
@PropertySource("classpath:db-config.properties")
public class ServiceConfiguration {

    protected Logger logger;

    public ServiceConfiguration() {
        logger = Logger.getLogger(getClass().getName());
    }

    @Bean
    public DataSource dataSource() {
        logger.info("datasource() invoked");

        DataSource dataSource = new EmbeddedDatabaseBuilder()
                .addScript("classpath:testdb/schema.sql")
                .addScript("classpath:testdb/data.sql")
                .build();


        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<Map<String, Object>> trainings = jdbcTemplate.queryForList("SELECT id FROM Training");
        logger.info("System has " + trainings.size() + " trainings");

        return dataSource;
    }


}
