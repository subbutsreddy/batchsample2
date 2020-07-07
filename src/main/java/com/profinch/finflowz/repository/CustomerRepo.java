package com.profinch.finflowz.repository;

import com.profinch.finflowz.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer,Long> {

    List<Customer> findByAccountStatement(boolean accountStatement);
    List<Customer> findByBalanceLessThan( int balance);

}
