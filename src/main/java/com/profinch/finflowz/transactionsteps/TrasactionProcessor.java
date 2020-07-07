package com.profinch.finflowz.transactionsteps;

import com.profinch.finflowz.model.TransactionDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.sql.Date;

@Configuration
public class TrasactionProcessor implements ItemProcessor<TransactionDetails, TransactionDetails> {

    private Logger log = LoggerFactory.getLogger(TrasactionProcessor.class);

    @Override
    public TransactionDetails process(TransactionDetails transactionDetails) throws Exception {

        return null;
    }
}
