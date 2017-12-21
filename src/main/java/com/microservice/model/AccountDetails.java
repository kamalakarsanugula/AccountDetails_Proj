package com.microservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Account_Details")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class AccountDetails implements Serializable {
    @Id
    @Column(name = "CONTRACT_ACCOUNT_NUMBER", length = 15, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "ACC_SEQ")
    @SequenceGenerator(sequenceName = "account_sequence", allocationSize = 1, name = "ACC_SEQ")

    private int contractAccountNumber;

    @Column(name = "SERVICE", length = 25)
    private String service;

    @Column(name = "ACCOUNT_BALANCE", length = 15)
    private String accountBalance;


    @Column(name = "DIRECT_DEBIT_AMT", length = 15)
    private String directDebitAmt;

    @Column(name = "METER_READING_TYPE", length = 25)
    private String meterReadingType;

    @Column(name = "PAYMENT_PLAN", length = 15)
    private String paymentPlan;

	/*@Column(name = "NEXT_METER_READING_DATE")
	private Instant nextMeterReadingDate;*/

    public AccountDetails() {
    }

    public AccountDetails(int contractAccountNumber, String service, String accountBalance, String directDebitAmt, String meterReadingType, String paymentPlan) {
        this.contractAccountNumber = contractAccountNumber;
        this.service = service;
        this.accountBalance = accountBalance;
        this.directDebitAmt = directDebitAmt;
        this.meterReadingType = meterReadingType;
        this.paymentPlan = paymentPlan;
    }

    public int getContractAccountNumber() {
        return contractAccountNumber;
    }

    public void setContractAccountNumber(int contractAccountNumber) {
        this.contractAccountNumber = contractAccountNumber;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(String accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getDirectDebitAmt() {
        return directDebitAmt;
    }

    public void setDirectDebitAmt(String directDebitAmt) {
        this.directDebitAmt = directDebitAmt;
    }

    public String getMeterReadingType() {
        return meterReadingType;
    }

    public void setMeterReadingType(String meterReadingType) {
        this.meterReadingType = meterReadingType;
    }

    public String getPaymentPlan() {
        return paymentPlan;
    }

    public void setPaymentPlan(String paymentPlan) {
        this.paymentPlan = paymentPlan;
    }


}
