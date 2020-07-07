

package com.profinch.finflowz.batch;

import com.profinch.finflowz.config.CustomerConfig;
import com.profinch.finflowz.model.TransactionDetails;
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
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class TransactionBatch {

    @Autowired
    private CustomerConfig customerConfig;

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    public Job job(JobBuilderFactory jobBuilderFactory,
                   StepBuilderFactory stepBuilderFactory,
                   ItemReader<TransactionDetails> itemReader,
                   ItemProcessor<TransactionDetails, TransactionDetails> itemProcessor,
                   ItemWriter<TransactionDetails> itemWriter ) {
        Step step = stepBuilderFactory.get("Transactionstep")
                .<TransactionDetails, TransactionDetails>chunk(customerConfig.getChunkSize())
                .reader(itemReader)
                .processor(itemProcessor)
                .writer(itemWriter)
                .build();


        return jobBuilderFactory.get("TransactionJob")
                .incrementer(new RunIdIncrementer())
                .start(step)
                .build();


    }}
