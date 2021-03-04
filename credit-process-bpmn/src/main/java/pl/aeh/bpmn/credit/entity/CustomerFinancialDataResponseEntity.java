package pl.aeh.bpmn.credit.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customer_financial_data_response")
public class CustomerFinancialDataResponseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_financial_data_response_id")
    public Long customerResponseId;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "currency_type")
    private String currencyType;

    @Column(name = "amount")
    private String amount;

    @Column(name = "credit_account_number")
    private String creditAccountNumber;

    @Column(name = "credit_amount")
    private String creditAmount;

    @Column(name = "last_payment")
    private String lastPayment;

    @OneToMany(mappedBy = "customerFinancialDataResponse", cascade = CascadeType.ALL)
    private Set<CustomerFinancialDataRequestResponseEntity> customerFinancialDataRequestResponse = new HashSet<CustomerFinancialDataRequestResponseEntity>();

    public CustomerFinancialDataResponseEntity() {
    }

    public Long getCustomerResponseId() {
        return customerResponseId;
    }

    public void setCustomerResponseId(Long customerResponseId) {
        this.customerResponseId = customerResponseId;
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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCreditAccountNumber() {
        return creditAccountNumber;
    }

    public void setCreditAccountNumber(String creditAccountNumber) {
        this.creditAccountNumber = creditAccountNumber;
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

    public Set<CustomerFinancialDataRequestResponseEntity> getCustomerFinancialDataRequestResponse() {
        return customerFinancialDataRequestResponse;
    }

    public void setCustomerFinancialDataRequestResponse(Set<CustomerFinancialDataRequestResponseEntity> customerFinancialDataRequestResponse) {
        this.customerFinancialDataRequestResponse = customerFinancialDataRequestResponse;
    }

    @Override
    public String toString() {
        return "CustomerFinancialDataResponseEntity{" +
                "customerResponseId='" + customerResponseId + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", currencyType='" + currencyType + '\'' +
                ", amount='" + amount + '\'' +
                ", creditAccountNumber='" + creditAccountNumber + '\'' +
                ", creditAmount='" + creditAmount + '\'' +
                ", lastPayment='" + lastPayment + '\'' +
                '}';
    }
}
