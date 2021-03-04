package pl.aeh.bpmn.credit.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "bank_credit_request")
public class BankCreditRequestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bank_credit_request_id")
    private Long creditRequestId;

    @Column(name = "date")
    private String date;

    @Column(name = "amount_of_credit_requested")
    private String amountOfCreditRequested;

    @Column(name = "customer_first_name")
    private String customerFirstName;

    @Column(name = "customer_last_name")
    private String customerLastName;

    @Column(name = "customer_passport_number")
    private String customerPassportNumber;

    @Column(name = "customer_phone")
    private String customerPhone;

    @Column(name = "customer_email")
    private String customerEmail;

    @Column(name = "customer_address")
    private String customerAddress;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "bank_address")
    private String bankAddress;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "bank_phone")
    private String bankPhone;

    @Column(name = "bank_email")
    private String bankEmail;

    @Column(name = "proposed_credit_method_payment")
    private String proposedCreditMethodPayment;

    @Column(name = "percent")
    private String percent;

    @Column(name = "additional_information")
    private String additionalInformation;

    @OneToMany(mappedBy = "bankCreditRequest", cascade = CascadeType.ALL)
    private Set<BankCreditRequestResponseEntity> bankCreditRequestResponse = new HashSet<BankCreditRequestResponseEntity>();

    public BankCreditRequestEntity() {
    }

    public Long getCreditRequestId() {
        return creditRequestId;
    }

    public void setCreditRequestId(Long creditRequestId) {
        this.creditRequestId = creditRequestId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAmountOfCreditRequested() {
        return amountOfCreditRequested;
    }

    public void setAmountOfCreditRequested(String amountOfCreditRequested) {
        this.amountOfCreditRequested = amountOfCreditRequested;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getCustomerPassportNumber() {
        return customerPassportNumber;
    }

    public void setCustomerPassportNumber(String customerPassportNumber) {
        this.customerPassportNumber = customerPassportNumber;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAddress() {
        return bankAddress;
    }

    public void setBankAddress(String bankAddress) {
        this.bankAddress = bankAddress;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBankPhone() {
        return bankPhone;
    }

    public void setBankPhone(String bankPhone) {
        this.bankPhone = bankPhone;
    }

    public String getBankEmail() {
        return bankEmail;
    }

    public void setBankEmail(String bankEmail) {
        this.bankEmail = bankEmail;
    }

    public String getProposedCreditMethodPayment() {
        return proposedCreditMethodPayment;
    }

    public void setProposedCreditMethodPayment(String proposedCreditMethodPayment) {
        this.proposedCreditMethodPayment = proposedCreditMethodPayment;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public Set<BankCreditRequestResponseEntity> getBankCreditRequestResponse() {
        return bankCreditRequestResponse;
    }

    public void setBankCreditRequestResponse(Set<BankCreditRequestResponseEntity> bankCreditRequestResponse) {
        this.bankCreditRequestResponse = bankCreditRequestResponse;
    }

    @Override
    public String toString() {
        return "BankCreditRequestEntity{" +
                "creditRequestId='" + creditRequestId + '\'' +
                ", date='" + date + '\'' +
                ", amountOfCreditRequested='" + amountOfCreditRequested + '\'' +
                ", customerFirstName='" + customerFirstName + '\'' +
                ", customerLastName='" + customerLastName + '\'' +
                ", customerPassportNumber='" + customerPassportNumber + '\'' +
                ", customerPhone='" + customerPhone + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", bankName='" + bankName + '\'' +
                ", bankAddress='" + bankAddress + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", bankPhone='" + bankPhone + '\'' +
                ", bankEmail='" + bankEmail + '\'' +
                ", proposedCreditMethodPayment='" + proposedCreditMethodPayment + '\'' +
                ", percent='" + percent + '\'' +
                ", additionalInformation='" + additionalInformation + '\'' +
                ", bankCreditRequestResponse=" + bankCreditRequestResponse +
                '}';
    }
}
