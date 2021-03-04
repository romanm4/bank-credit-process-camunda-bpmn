package pl.aeh.bpmn.credit.mock.model;

import java.math.BigDecimal;
import java.util.Date;

public class ContractRequest {

    private BigDecimal loanAmount;
    private Date date;
    private String firstName;
    private String lastName;
    private String address;
    private double percent;
    private String proposedCreditMethodPayment;
    private String additionalInformation;

    public ContractRequest() {
    }

    public ContractRequest(BigDecimal loanAmount, Date date, String firstName, String lastName, String address, double percent, String proposedCreditMethodPayment, String additionalInformation) {
        this.loanAmount = loanAmount;
        this.date = date;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.percent = percent;
        this.proposedCreditMethodPayment = proposedCreditMethodPayment;
        this.additionalInformation = additionalInformation;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public String getProposedCreditMethodPayment() {
        return proposedCreditMethodPayment;
    }

    public void setProposedCreditMethodPayment(String proposedCreditMethodPayment) {
        this.proposedCreditMethodPayment = proposedCreditMethodPayment;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    @Override
    public String toString() {
        return "ContractRequest{" +
                "loanAmount=" + loanAmount +
                ", date=" + date +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", percent=" + percent +
                ", proposedCreditMethodPayment='" + proposedCreditMethodPayment + '\'' +
                ", additionalInformation='" + additionalInformation + '\'' +
                '}';
    }
}
