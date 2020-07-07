package com.profinch.finflowz.transactionsteps;

import com.profinch.finflowz.model.TransactionDetails;
import com.profinch.finflowz.repository.TransactionDetailsRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TrasactionWriter implements ItemWriter<TransactionDetails> {

    private Logger log = LoggerFactory.getLogger(TrasactionWriter.class);
    private TransactionDetailsRepo transactionDetailsRepo;

    public TrasactionWriter(TransactionDetailsRepo transactionDetailsRepo) {
        this.transactionDetailsRepo = transactionDetailsRepo;
    }

    @Override
    public void write(List<? extends TransactionDetails> list) throws Exception {
        if (list.size() > 0) {
            for (TransactionDetails transactionDetails : list) {
                log.debug("ItemWriter for the TransactionDetails{} ", transactionDetails.getTransactionReferanceNumber());
                transactionDetailsRepo.deleteById(transactionDetails.getTransactionReferanceNumber());
            }

        }else {
            log.debug("ItemWriter  does not write or delete any thing due to list size is zero {} ",list.size());
        }

    }
}
