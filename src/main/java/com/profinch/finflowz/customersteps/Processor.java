package com.profinch.finflowz.customersteps;

import com.profinch.finflowz.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Processor implements ItemProcessor<Customer,Customer> {

    private Logger log = LoggerFactory.getLogger(Processor.class);

    @Override
    public Customer process(Customer customer) throws Exception {

        log.debug("Workflow Processor before customerAccountStatement :{} {}{}",customer.getAccountId(),customer.getAccountStatement());
        customer.setAccountStatement(true);

        int bal =customer.getBalance();
        log.debug(" before balance increment :{}",bal);
        int balance1 =bal+bal;
        log.debug("after balance increment:{}",balance1);
        customer.setBalance(balance1);
        log.debug("Processor after customerBalance :{} {}",customer.getAccountId(),customer.getBalance());
        return customer;
    }

    }

