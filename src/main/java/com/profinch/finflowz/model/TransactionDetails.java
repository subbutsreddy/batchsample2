package com.profinch.finflowz.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.sql.Time;


@Getter
@Setter
@Entity
@Table(name = "Transaction_Details_exp")
public class TransactionDetails {
	@Id
    private String transactionReferanceNumber;
	private Long amount;
	private Date date;
	private String statusCode;
	private Time transactionTime;
    private int processId;
    private String messege;

    @Override
    public String toString() {
        return "TransactionDetails1{" +
                "transactionReferanceNumber='" + transactionReferanceNumber + '\'' +
                ", amount='" + amount + '\'' +
                ", date=" + date +
                ", statusCode=" + statusCode +
                ", trsactionTime=" + transactionTime +
                ", processId='" + processId + '\'' +
                ", messege='" + messege + '\'' +
                '}';
    }
}