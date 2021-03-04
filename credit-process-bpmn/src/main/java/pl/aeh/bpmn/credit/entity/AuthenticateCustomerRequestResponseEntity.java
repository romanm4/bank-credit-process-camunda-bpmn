package pl.aeh.bpmn.credit.entity;

import javax.persistence.*;

@Entity
@Table(name = "authenticate_customer_request_response")
public class AuthenticateCustomerRequestResponseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "authenticate_customer_request_id")
    private AuthenticateCustomerRequestEntity authenticateCustomerRequest;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "authenticate_customer_response_id")
    private AuthenticateCustomerResponseEntity authenticateCustomerResponse;

    @Column(name = "process_id")
    private String processId;

    public AuthenticateCustomerRequestResponseEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AuthenticateCustomerRequestEntity getAuthenticateCustomerRequest() {
        return authenticateCustomerRequest;
    }

    public void setAuthenticateCustomerRequest(AuthenticateCustomerRequestEntity authenticateCustomerRequest) {
        this.authenticateCustomerRequest = authenticateCustomerRequest;
    }

    public AuthenticateCustomerResponseEntity getAuthenticateCustomerResponse() {
        return authenticateCustomerResponse;
    }

    public void setAuthenticateCustomerResponse(AuthenticateCustomerResponseEntity authenticateCustomerResponse) {
        this.authenticateCustomerResponse = authenticateCustomerResponse;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    @Override
    public String toString() {
        return "AuthenticateCustomerRequestResponseEntity{" +
                "id=" + id +
                ", processId='" + processId + '\'' +
                '}';
    }
}
