package demo;

import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.configuration.DuplicateJobException;
import org.springframework.batch.core.configuration.annotation.BatchConfigurer;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import demo.configuration.BatchAdminConfiguration;

@Configuration
@ComponentScan(basePackages = "demo.*")
@EnableAutoConfiguration(exclude= BatchConfigurer.class)
@Import({BatchAdminConfiguration.class})
public class Application {

    public static void main(String[] args) throws JobExecutionAlreadyRunningException, JobRestartException,
            JobInstanceAlreadyCompleteException, JobParametersInvalidException, DuplicateJobException {
        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);

    }
}
