package pl.aeh.bpmn.credit.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "bank_credit_response")
public class BankCreditResponseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bank_credit_response_id")
    private Long bankCreditResponseId;

    @Column(name = "response_status")
    private String status;

    @OneToMany(mappedBy = "bankCreditResponse", cascade = CascadeType.ALL)
    private Set<BankCreditRequestResponseEntity> bankCreditRequestResponse = new HashSet<BankCreditRequestResponseEntity>();

    public BankCreditResponseEntity() {
    }

    public Long getBankCreditResponseId() {
        return bankCreditResponseId;
    }

    public void setBankCreditResponseId(Long bankCreditResponseId) {
        this.bankCreditResponseId = bankCreditResponseId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<BankCreditRequestResponseEntity> getBankCreditRequestResponse() {
        return bankCreditRequestResponse;
    }

    public void setBankCreditRequestResponse(Set<BankCreditRequestResponseEntity> bankCreditRequestResponse) {
        this.bankCreditRequestResponse = bankCreditRequestResponse;
    }

    @Override
    public String toString() {
        return "BankCreditResponseEntity{" +
                "bankCreditResponseId=" + bankCreditResponseId +
                ", status='" + status + '\'' +
                ", bankCreditRequestResponse=" + bankCreditRequestResponse +
                '}';
    }
}
