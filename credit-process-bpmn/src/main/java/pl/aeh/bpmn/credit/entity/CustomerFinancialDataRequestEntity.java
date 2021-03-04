package pl.aeh.bpmn.credit.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customer_financial_data_request")
public class CustomerFinancialDataRequestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_financial_data_request_id")
    public Long customerRequestId;

    @Column(name = "customer_id")
    public String customerId;

    @OneToMany(mappedBy = "customerFinancialDataRequest", cascade = CascadeType.ALL)
    private Set<CustomerFinancialDataRequestResponseEntity> customerFinancialDataRequestResponse = new HashSet<CustomerFinancialDataRequestResponseEntity>();

    public CustomerFinancialDataRequestEntity() {
    }

    public Long getCustomerRequestId() {
        return customerRequestId;
    }

    public void setCustomerRequestId(Long customerRequestId) {
        this.customerRequestId = customerRequestId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Set<CustomerFinancialDataRequestResponseEntity> getCustomerFinancialDataRequestResponse() {
        return customerFinancialDataRequestResponse;
    }

    public void setCustomerFinancialDataRequestResponse(Set<CustomerFinancialDataRequestResponseEntity> customerFinancialDataRequestResponse) {
        this.customerFinancialDataRequestResponse = customerFinancialDataRequestResponse;
    }

    @Override
    public String toString() {
        return "CustomerFinancialDataRequestEntity{" +
                "customerRequestId='" + customerRequestId + '\'' +
                ", customerId='" + customerId + '\'' +
                '}';
    }
}
