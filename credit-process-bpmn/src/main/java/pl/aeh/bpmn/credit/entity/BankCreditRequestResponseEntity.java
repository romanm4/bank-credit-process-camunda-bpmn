package pl.aeh.bpmn.credit.entity;

import javax.persistence.*;

@Entity
@Table(name = "bank_credit_request_response")
public class BankCreditRequestResponseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_credit_request_id")
    private BankCreditRequestEntity bankCreditRequest;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_credit_response_id")
    private BankCreditResponseEntity bankCreditResponse;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contract_request_id")
    private ContractRequestEntity contractRequest;

    @Column(name = "process_id")
    private String processId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BankCreditRequestEntity getBankCreditRequest() {
        return bankCreditRequest;
    }

    public void setBankCreditRequest(BankCreditRequestEntity bankCreditRequest) {
        this.bankCreditRequest = bankCreditRequest;
    }

    public BankCreditResponseEntity getBankCreditResponse() {
        return bankCreditResponse;
    }

    public void setBankCreditResponse(BankCreditResponseEntity bankCreditResponse) {
        this.bankCreditResponse = bankCreditResponse;
    }

    public ContractRequestEntity getContractRequest() {
        return contractRequest;
    }

    public void setContractRequest(ContractRequestEntity contractRequest) {
        this.contractRequest = contractRequest;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    @Override
    public String toString() {
        return "BankCreditRequestResponseEntity{" +
                "id=" + id +
                ", processId='" + processId + '\'' +
                '}';
    }
}
