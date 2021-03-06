package pl.aeh.bpmn.credit.mock.model;

import java.math.BigDecimal;

public class CreditRequest {

    private String currencyType;
    private String accountNumber;
    private BigDecimal creditAmount;
    private BigDecimal lastPayment;

    public CreditRequest() {
    }

    public CreditRequest(String currencyType, String accountNumber, BigDecimal creditAmount, BigDecimal lastPayment) {
        this.currencyType = currencyType;
        this.accountNumber = accountNumber;
        this.creditAmount = creditAmount;
        this.lastPayment = lastPayment;
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(BigDecimal creditAmount) {
        this.creditAmount = creditAmount;
    }

    public BigDecimal getLastPayment() {
        return lastPayment;
    }

    public void setLastPayment(BigDecimal lastPayment) {
        this.lastPayment = lastPayment;
    }

    @Override
    public String toString() {
        return "CreditRequest{" +
                "currencyType='" + currencyType + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", creditAmount=" + creditAmount +
                ", lastPayment=" + lastPayment +
                '}';
    }
}
