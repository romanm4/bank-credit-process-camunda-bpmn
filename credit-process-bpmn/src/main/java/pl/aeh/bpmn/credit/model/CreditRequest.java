package pl.aeh.bpmn.credit.model;

import java.math.BigDecimal;
import java.util.Date;

public class CreditRequest {

    private Date date;
    private BigDecimal amountOfCreditRequested;
    private Customer customerDetails;
    private Bank bankDetails;
    private ProposedCreditMethodPayment proposedCreditMethodPayment;
    private double percent;
    private String additionalInformation;

    public CreditRequest() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getAmountOfCreditRequested() {
        return amountOfCreditRequested;
    }

    public void setAmountOfCreditRequested(BigDecimal amountOfCreditRequested) {
        this.amountOfCreditRequested = amountOfCreditRequested;
    }

    public Customer getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(Customer customerDetails) {
        this.customerDetails = customerDetails;
    }

    public Bank getBankDetails() {
        return bankDetails;
    }

    public void setBankDetails(Bank bankDetails) {
        this.bankDetails = bankDetails;
    }

    public ProposedCreditMethodPayment getProposedCreditMethodPayment() {
        return proposedCreditMethodPayment;
    }

    public void setProposedCreditMethodPayment(ProposedCreditMethodPayment proposedCreditMethodPayment) {
        this.proposedCreditMethodPayment = proposedCreditMethodPayment;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    @Override
    public String toString() {
        return "CreditRequest{" +
                "date=" + date +
                ", amountOfCreditRequested=" + amountOfCreditRequested +
                ", customerDetails=" + customerDetails +
                ", bankDetails=" + bankDetails +
                ", proposedCreditMethodPayment=" + proposedCreditMethodPayment +
                ", percent=" + percent +
                ", additionalInformation='" + additionalInformation + '\'' +
                '}';
    }
}
