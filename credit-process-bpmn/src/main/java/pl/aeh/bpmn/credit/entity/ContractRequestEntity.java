package pl.aeh.bpmn.credit.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "contract")
public class ContractRequestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_request_id")
    private Long creditId;

    @Column(name = "loan_amount")
    private String loanAmount;

    @Column(name = "date")
    private String date;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "address")
    private String address;

    @Column(name = "percent")
    private double percent;

    @Column(name = "proposed_credit_method_payment")
    private String proposedCreditMethodPayment;

    @Column(name = "additional_information")
    private String additionalInformation;

    @OneToMany(mappedBy = "contractRequest", cascade = CascadeType.ALL)
    private Set<BankCreditRequestResponseEntity> bankCreditRequestResponse = new HashSet<BankCreditRequestResponseEntity>();

    public ContractRequestEntity() {
    }

    public Long getCreditId() {
        return creditId;
    }

    public void setCreditId(Long creditId) {
        this.creditId = creditId;
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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

    public Set<BankCreditRequestResponseEntity> getBankCreditRequestResponse() {
        return bankCreditRequestResponse;
    }

    public void setBankCreditRequestResponse(Set<BankCreditRequestResponseEntity> bankCreditRequestResponse) {
        this.bankCreditRequestResponse = bankCreditRequestResponse;
    }

    @Override
    public String toString() {
        return "ContractRequestEntity{" +
                "creditId='" + creditId + '\'' +
                ", loanAmount='" + loanAmount + '\'' +
                ", date='" + date + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", percent=" + percent +
                ", proposedCreditMethodPayment='" + proposedCreditMethodPayment + '\'' +
                ", additionalInformation='" + additionalInformation + '\'' +
                '}';
    }
}
