package com.profinch.finflowz.batch;

import com.profinch.finflowz.model.Customer;
import com.profinch.finflowz.config.CustomerConfig;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class ConfigBatch {
    @Autowired
    private CustomerConfig customerConfig;
    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job job(JobBuilderFactory jobBuilderFactory,
                   StepBuilderFactory stepBuilderFactory,
                   ItemReader<Customer> itemReader,
                   ItemProcessor<Customer, Customer> itemProcessor,
                   ItemWriter<Customer> itemWriter) {
        Step step = stepBuilderFactory.get("Customerstep")
                .<Customer, Customer>chunk(customerConfig.getChunkSize())
                .reader(itemReader)
                .processor(itemProcessor)
                .writer(itemWriter)
                .build();


        return jobBuilderFactory.get("CustomerJob")
                .incrementer(new RunIdIncrementer())
                .start(step)
                .build();
    }


}
