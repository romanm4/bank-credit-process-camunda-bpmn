package pl.aeh.bpmn.credit.model;

import java.math.BigDecimal;

public class CreditData {

    private String creditAccountNumber;
    private BigDecimal creditAmount;
    private BigDecimal lastPayment;

    public CreditData() {
    }

    public CreditData(String creditAccountNumber, BigDecimal creditAmount, BigDecimal lastPayment) {
        this.creditAccountNumber = creditAccountNumber;
        this.creditAmount = creditAmount;
        this.lastPayment = lastPayment;
    }

    public String getCreditAccountNumber() {
        return creditAccountNumber;
    }

    public void setCreditAccountNumber(String creditAccountNumber) {
        this.creditAccountNumber = creditAccountNumber;
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
        return "CreditData{" +
                "creditAccountNumber='" + creditAccountNumber + '\'' +
                ", creditAmount=" + creditAmount +
                ", lastPayment=" + lastPayment +
                '}';
    }
}
