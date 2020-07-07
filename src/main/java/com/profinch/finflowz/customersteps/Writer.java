package com.profinch.finflowz.customersteps;

import com.profinch.finflowz.model.Customer;
import com.profinch.finflowz.repository.CustomerRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class Writer implements ItemWriter<Customer> {

    private Logger log = LoggerFactory.getLogger(Writer.class);

    private CustomerRepo customerRepo;

    public Writer(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public void write(List<? extends Customer >customerlist) throws Exception {
        for (Customer customer:customerlist){
            log.debug("ItemWriter for the customer{} ",  customer.getAccountId());
            customerRepo.save(customer);
        }


    }
}
