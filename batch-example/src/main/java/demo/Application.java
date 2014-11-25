package demo;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobInstance;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.configuration.DuplicateJobException;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.configuration.annotation.BatchConfigurer;
import org.springframework.batch.core.configuration.support.MapJobRegistry;
import org.springframework.batch.core.configuration.support.ReferenceJobFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import demo.configuration.BatchAdminConfiguration;
import demo.configuration.BatchImporterConfiguration;

@Configuration
@ComponentScan(basePackages = "demo.*")
@EnableAutoConfiguration(exclude= BatchConfigurer.class)
@Import({BatchAdminConfiguration.class, BatchImporterConfiguration.class})
public class Application {

    public static void main(String[] args) throws JobExecutionAlreadyRunningException, JobRestartException,
            JobInstanceAlreadyCompleteException, JobParametersInvalidException, DuplicateJobException {
        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);

        Job simpleJob = ctx.getBean("simpleJob", Job.class);
        JobRegistry jobRegistry = ctx.getBean("jobRegistry", JobRegistry.class);
        jobRegistry.register(new ReferenceJobFactory(simpleJob));
        
        //JobRepository jobRepository = ctx.getBean("jobRepository", JobRepository.class);
        //JobInstance jobInstance = jobRepository.createJobInstance("simpleJob", new JobParameters());
        // JobParameters jobParameters = ctx.getBean("basicParameters", JobParameters.class);
        //
        //JobRegistry jobRegistry = ctx.getBean("mapJobRegistry", JobRegistry.class);
        // jobRegistry.register();
        // jobLauncher.run(job, jobParameters);
    }
}
