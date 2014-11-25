package demo.configuration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
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
    

//    @Autowired
//    private JobRepository jobRepository;

//    @Autowired
//    private SourceDataGenerator sourceDataGenerator;

//    @Autowired
//    private DataProcessor dataProcessor;

//    @Autowired
//    private TargetDataWriter targetDataWriter;
//    
//    @Autowired
//    @Qualifier("transactionManager")
//    private DataSourceTransactionManager transactionManager;
//
//    
//    @Bean
//    public org.springframework.batch.core.scope.JobScope jobScope() {
//        org.springframework.batch.core.scope.JobScope jobScope = new org.springframework.batch.core.scope.JobScope();
//        //jobScope.setAutoProxy(false);
//        //jobScope.setProxyTargetClass(true);
//        return jobScope;
//    }
    
//      @Bean(name="myStepScope")
//      public org.springframework.batch.core.scope.StepScope stepScope() {
//          org.springframework.batch.core.scope.StepScope stepScope = new org.springframework.batch.core.scope.StepScope();
//          stepScope.setProxyTargetClass(false);
//          stepScope.setAutoProxy(false);
//          return stepScope;
//      }
    
//    @Bean
//    public JobBuilderFactory jobBuilderFactory() {
//        return new JobBuilderFactory(jobRepository);
//    }
//
//    @Bean
//    public StepBuilderFactory stepBuilderFactory() {
//        return new StepBuilderFactory(jobRepository, transactionManager);
//    }
//
//    @Bean
//    @JobScope
//    public SourceDataGenerator sourceDataGenerator(){
//       return new SourceDataGenerator();
//    }
//    
//    @Bean
//    @JobScope
//    public DataProcessor dataProcessor(){
//       return new DataProcessor();
//    }
//    
//    @Bean
//    @JobScope
//    public TargetDataWriter targetDataWriter(){
//       return new TargetDataWriter();
//    }
//    
//    
//    //
//    //
//    // @Bean(name="basicParameters")
//    // public JobParameters jobParameters(){
//    // return new JobParametersBuilder()
//    // .addString("startValue", "10")
//    // .addString("endValue", "50").toJobParameters();
//    // }
//    //
//    
//    @Bean(name = "simpleJob")
//    public Job simpleJob() {
//        return jobBuilderFactory().get("simpleJob").flow(step()).end().build();
//    }
//
//    @Bean
//    public Step step() {
//        return stepBuilderFactory().get("simpleStep").<SourceData, TargetData> chunk(10).reader(sourceDataGenerator()).processor(
//                dataProcessor()).writer(targetDataWriter()).build();
//    }
    

}
