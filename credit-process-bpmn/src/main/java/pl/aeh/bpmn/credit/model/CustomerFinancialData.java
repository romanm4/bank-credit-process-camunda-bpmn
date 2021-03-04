package pl.aeh.bpmn.credit.model;

import java.math.BigDecimal;

public class CustomerFinancialData {

    private String accountNumber;
    private String currencyType;
    private BigDecimal amount;
    private CreditData creditData;

    public CustomerFinancialData() {
    }

    public CustomerFinancialData(String accountNumber, String currencyType, BigDecimal amount, CreditData creditData) {
        this.accountNumber = accountNumber;
        this.currencyType = currencyType;
        this.amount = amount;
        this.creditData = creditData;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public CreditData getCreditData() {
        return creditData;
    }

    public void setCreditData(CreditData creditData) {
        this.creditData = creditData;
    }

    @Override
    public String toString() {
        return "CustomerFinancialData{" +
                "accountNumber='" + accountNumber + '\'' +
                ", currencyType='" + currencyType + '\'' +
                ", amount=" + amount +
                ", creditData=" + creditData +
                '}';
    }
}
