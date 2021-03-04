package pl.aeh.bpmn.credit.entity;

import javax.persistence.*;

@Entity
@Table(name = "validate_credit_request_response")
public class ValidateCreditRequestResponseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "validate_credit_request_id")
    private ValidateCreditRequestEntity validateCreditRequest;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "validate_credit_response_id")
    private ValidateCreditResponseEntity validateCreditResponse;

    @Column(name = "process_id")
    private String processId;

    public ValidateCreditRequestResponseEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ValidateCreditRequestEntity getValidateCreditRequest() {
        return validateCreditRequest;
    }

    public void setValidateCreditRequest(ValidateCreditRequestEntity validateCreditRequest) {
        this.validateCreditRequest = validateCreditRequest;
    }

    public ValidateCreditResponseEntity getValidateCreditResponse() {
        return validateCreditResponse;
    }

    public void setValidateCreditResponse(ValidateCreditResponseEntity validateCreditResponse) {
        this.validateCreditResponse = validateCreditResponse;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    @Override
    public String toString() {
        return "ValidateCreditRequestResponseEntity{" +
                "id=" + id +
                ", processId='" + processId + '\'' +
                '}';
    }
}
