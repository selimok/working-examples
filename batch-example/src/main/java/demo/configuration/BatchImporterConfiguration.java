package demo.configuration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import demo.impl.DataProcessor;
import demo.impl.SourceDataGenerator;
import demo.impl.TargetDataWriter;
import demo.model.SourceData;
import demo.model.TargetData;

@Configuration
@EnableBatchProcessing
public class BatchImporterConfiguration {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Autowired
	private SourceDataGenerator sourceDataGenerator;

	@Autowired
	private DataProcessor dataProcessor;

	@Autowired
	private TargetDataWriter targetDataWriter;

	@Bean
	public Job simpleJob() {
		return jobBuilderFactory.get("simpleJob").flow(step()).end().build();
	}

	@Bean
	public Step step() {
		return stepBuilderFactory.get("step")
				.<SourceData, TargetData> chunk(10).reader(sourceDataGenerator)
				.processor(dataProcessor).writer(targetDataWriter).build();
	}

}
