package demo;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import demo.configuration.BatchImporterConfiguration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@Import(BatchImporterConfiguration.class)
public class Application {
	
    public static void main(String[] args) throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
        
        Job job = ctx.getBean("simpleJob", Job.class);
        JobParameters jobParameters = ctx.getBean("basicParameters", JobParameters.class);
        
        JobLauncher jobLauncher = ctx.getBean("jobLauncher", JobLauncher.class);
        jobLauncher.run(job, jobParameters);
    }
}
