package com.profinch.finflowz.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "Customer_exp")
public class Customer  {
    @Id
    private Long accountId;
    private String name;
    private Boolean accountStatement;
    private int balance;

    @Override
    public String toString() {
        return "Customer{" +
                "accountId=" + accountId +
                ", name='" + name + '\'' +
                ", accountStatement=" + accountStatement +
                ", balance=" + balance +
                '}';
    }
}
