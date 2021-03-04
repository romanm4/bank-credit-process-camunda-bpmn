package pl.aeh.bpmn.credit.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "validate_credit_response")
public class ValidateCreditResponseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "validate_credit_response_id")
    private Long validateCreditResponseId;

    @Column(name = "is_valid")
    private boolean valid;

    @Column(name = "is_updatable")
    private boolean updatable;

    @OneToMany(mappedBy = "validateCreditResponse", cascade = CascadeType.ALL)
    private Set<ValidateCreditRequestResponseEntity> validateCreditRequestResponse = new HashSet<ValidateCreditRequestResponseEntity>();

    public ValidateCreditResponseEntity() {
    }

    public Long getValidateCreditResponseId() {
        return validateCreditResponseId;
    }

    public void setValidateCreditResponseId(Long validateCreditResponseId) {
        this.validateCreditResponseId = validateCreditResponseId;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public boolean isUpdatable() {
        return updatable;
    }

    public void setUpdatable(boolean updatable) {
        this.updatable = updatable;
    }

    public Set<ValidateCreditRequestResponseEntity> getValidateCreditRequestResponse() {
        return validateCreditRequestResponse;
    }

    public void setValidateCreditRequestResponse(Set<ValidateCreditRequestResponseEntity> validateCreditRequestResponse) {
        this.validateCreditRequestResponse = validateCreditRequestResponse;
    }

    @Override
    public String toString() {
        return "ValidateCreditResponseEntity{" +
                "validateCreditResponseId='" + validateCreditResponseId + '\'' +
                ", valid=" + valid +
                ", updatable=" + updatable +
                ", validateCreditRequestResponse=" + validateCreditRequestResponse +
                '}';
    }
}
