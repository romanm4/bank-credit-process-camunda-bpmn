package pl.aeh.bpmn.credit.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "validate_credit_request")
public class ValidateCreditRequestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "validate_credit_request_id")
    private Long validateCreditRequestId;

    @Column(name = "currency_type")
    private String currencyType;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "credit_amount")
    private String creditAmount;

    @Column(name = "last_payment")
    private String lastPayment;

    @OneToMany(mappedBy = "validateCreditRequest", cascade = CascadeType.ALL)
    private Set<ValidateCreditRequestResponseEntity> validateCreditRequestResponse = new HashSet<ValidateCreditRequestResponseEntity>();

    public ValidateCreditRequestEntity() {
    }

    public Long getValidateCreditRequestId() {
        return validateCreditRequestId;
    }

    public void setValidateCreditRequestId(Long validateCreditRequestId) {
        this.validateCreditRequestId = validateCreditRequestId;
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

    public String getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(String creditAmount) {
        this.creditAmount = creditAmount;
    }

    public String getLastPayment() {
        return lastPayment;
    }

    public void setLastPayment(String lastPayment) {
        this.lastPayment = lastPayment;
    }

    public Set<ValidateCreditRequestResponseEntity> getValidateCreditRequestResponse() {
        return validateCreditRequestResponse;
    }

    public void setValidateCreditRequestResponse(Set<ValidateCreditRequestResponseEntity> validateCreditRequestResponse) {
        this.validateCreditRequestResponse = validateCreditRequestResponse;
    }

    @Override
    public String toString() {
        return "ValidateCreditRequestEntity{" +
                "validateCreditRequestId='" + validateCreditRequestId + '\'' +
                ", currencyType='" + currencyType + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", creditAmount='" + creditAmount + '\'' +
                ", lastPayment='" + lastPayment + '\'' +
                '}';
    }
}
