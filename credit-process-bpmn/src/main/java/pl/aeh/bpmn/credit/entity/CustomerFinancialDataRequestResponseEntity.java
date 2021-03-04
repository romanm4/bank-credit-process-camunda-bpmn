package pl.aeh.bpmn.credit.entity;

import javax.persistence.*;

@Entity
@Table(name = "customer_financial_data_request_response")
public class CustomerFinancialDataRequestResponseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_financial_data_request_id")
    private CustomerFinancialDataRequestEntity customerFinancialDataRequest;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_financial_data_response_id")
    private CustomerFinancialDataResponseEntity customerFinancialDataResponse;

    @Column(name = "process_id")
    private String processId;

    public CustomerFinancialDataRequestResponseEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CustomerFinancialDataRequestEntity getCustomerFinancialDataRequest() {
        return customerFinancialDataRequest;
    }

    public void setCustomerFinancialDataRequest(CustomerFinancialDataRequestEntity customerFinancialDataRequest) {
        this.customerFinancialDataRequest = customerFinancialDataRequest;
    }

    public CustomerFinancialDataResponseEntity getCustomerFinancialDataResponse() {
        return customerFinancialDataResponse;
    }

    public void setCustomerFinancialDataResponse(CustomerFinancialDataResponseEntity customerFinancialDataResponse) {
        this.customerFinancialDataResponse = customerFinancialDataResponse;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    @Override
    public String toString() {
        return "CustomerFinancialDataRequestResponseEntity{" +
                "id=" + id +
                ", processId='" + processId + '\'' +
                '}';
    }
}
