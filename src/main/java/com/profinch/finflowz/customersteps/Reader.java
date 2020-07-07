package com.profinch.finflowz.customersteps;

import com.profinch.finflowz.model.Customer;
import com.profinch.finflowz.repository.CustomerRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class Reader implements ItemReader<Customer> {

    private Logger log = LoggerFactory.getLogger(Reader.class);

    private CustomerRepo customerRepo;


    public Reader(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public Customer read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {


        log.debug("Reading the data where customertable whos accountSatatement is ");
        List<Customer> customers
                = customerRepo.findByAccountStatement(false);

        for (Customer customer : customers) {
            log.debug("Itemreader{} ", customer.getAccountId());
            return customer;
        }
        log.debug("Reading the data where customertable whos balance is ");
        List<Customer> customersBal =customerRepo.findByBalanceLessThan(100000);
        for (Customer customersBalance : customersBal) {
            log.debug("Itemreader{} ", customersBalance.getAccountId());
            return customersBalance;
        }
        return null;
    }

}

