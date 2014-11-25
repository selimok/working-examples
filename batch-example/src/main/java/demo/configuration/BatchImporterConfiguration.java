package demo.configuration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.DuplicateJobException;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.configuration.support.ApplicationContextFactory;
import org.springframework.batch.core.configuration.support.ApplicationContextJobFactory;
import org.springframework.batch.core.configuration.support.MapJobRegistry;
import org.springframework.batch.core.configuration.support.ReferenceJobFactory;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;
import org.springframework.batch.core.scope.JobScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import demo.impl.DataProcessor;
import demo.impl.SourceDataGenerator;
import demo.impl.TargetDataWriter;
import demo.model.SourceData;
import demo.model.TargetData;

@Configuration
//@EnableBatchProcessing
public class BatchImporterConfiguration {

//     @Autowired
//     private JobBuilderFactory jobBuilderFactory;
//
//     @Autowired
//     private StepBuilderFactory stepBuilderFactory;
    

    @Autowired
    private JobRepository jobRepository;

//    @Autowired
//    private SourceDataGenerator sourceDataGenerator;

    @Autowired
    private DataProcessor dataProcessor;

    @Autowired
    private TargetDataWriter targetDataWriter;
    
    @Autowired
    @Qualifier("transactionManager")
    private DataSourceTransactionManager transactionManager;

    
//    @Bean
//    public JobScope jobScope() {
//        return new JobScope();
//    }
    
    @Bean
    public JobBuilderFactory jobBuilderFactory() {
        return new JobBuilderFactory(jobRepository);
    }

    @Bean
    public StepBuilderFactory stepBuilderFactory() {
        
        return new StepBuilderFactory(jobRepository, transactionManager);
    }

    @Bean
    @StepScope
    public SourceDataGenerator sourceDataGenerator(){
       return new SourceDataGenerator();
    }
    //
    //
    // @Bean(name="basicParameters")
    // public JobParameters jobParameters(){
    // return new JobParametersBuilder()
    // .addString("startValue", "10")
    // .addString("endValue", "50").toJobParameters();
    // }
    //
    
    @Bean(name = "simpleJob")
    public Job simpleJob() {
        return jobBuilderFactory().get("simpleJob").flow(step()).end().build();
    }

    @Bean
    public Step step() {
        return stepBuilderFactory().get("step").<SourceData, TargetData> chunk(10).reader(sourceDataGenerator()).processor(
                dataProcessor).writer(targetDataWriter).build();
    }
    

}
