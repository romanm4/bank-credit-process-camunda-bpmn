package pl.aeh.bpmn.credit.dto;

import pl.aeh.bpmn.credit.model.CreditRequestValidateInfo;
import pl.aeh.bpmn.credit.model.CustomerFinancialData;
import pl.aeh.bpmn.credit.model.Token;
import pl.aeh.bpmn.credit.model.CreditRequest;

public class ProcessVariableDTO {

    private String processId;
    private CustomerFinancialData customerFinancialData;
    private boolean isCustomerExist;
    private boolean isValidateCreditRequest;
    private CreditRequest creditRequest;
    private String customerId;
    private boolean isUpdateContract;
    private CreditResponseDTO creditResponseDTO;
    private ErrorCreditResponseDTO errorCreditResponseDTO;
    private AuthenticateDTO authenticateDTO;
    private Token token;
    private CreditRequestDTO creditRequestDTO;
    private CreditRequestValidateInfo creditRequestValidateInfo;

    public ProcessVariableDTO() {
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public CustomerFinancialData getCustomerFinancialData() {
        return customerFinancialData;
    }

    public void setCustomerFinancialData(CustomerFinancialData customerFinancialData) {
        this.customerFinancialData = customerFinancialData;
    }

    public boolean isCustomerExist() {
        return isCustomerExist;
    }

    public void setCustomerExist(boolean customerExist) {
        isCustomerExist = customerExist;
    }

    public boolean isValidateCreditRequest() {
        return isValidateCreditRequest;
    }

    public void setValidateCreditRequest(boolean validateCreditRequest) {
        isValidateCreditRequest = validateCreditRequest;
    }

    public CreditRequest getCreditRequest() {
        return creditRequest;
    }

    public void setCreditRequest(CreditRequest creditRequest) {
        this.creditRequest = creditRequest;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public boolean isUpdateContract() {
        return isUpdateContract;
    }

    public void setUpdateContract(boolean updateContract) {
        isUpdateContract = updateContract;
    }

    public CreditResponseDTO getCreditResponseDTO() {
        return creditResponseDTO;
    }

    public void setCreditResponseDTO(CreditResponseDTO creditResponseDTO) {
        this.creditResponseDTO = creditResponseDTO;
    }

    public ErrorCreditResponseDTO getErrorCreditResponseDTO() {
        return errorCreditResponseDTO;
    }

    public void setErrorCreditResponseDTO(ErrorCreditResponseDTO errorCreditResponseDTO) {
        this.errorCreditResponseDTO = errorCreditResponseDTO;
    }

    public AuthenticateDTO getAuthenticateDTO() {
        return authenticateDTO;
    }

    public void setAuthenticateDTO(AuthenticateDTO authenticateDTO) {
        this.authenticateDTO = authenticateDTO;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public CreditRequestDTO getCreditRequestDTO() {
        return creditRequestDTO;
    }

    public void setCreditRequestDTO(CreditRequestDTO creditRequestDTO) {
        this.creditRequestDTO = creditRequestDTO;
    }

    public CreditRequestValidateInfo getCreditRequestValidateInfo() {
        return creditRequestValidateInfo;
    }

    public void setCreditRequestValidateInfo(CreditRequestValidateInfo creditRequestValidateInfo) {
        this.creditRequestValidateInfo = creditRequestValidateInfo;
    }

    @Override
    public String toString() {
        return "ProcessVariableDTO{" +
                "processId='" + processId + '\'' +
                ", customerFinancialData=" + customerFinancialData +
                ", isCustomerExist=" + isCustomerExist +
                ", isValidateCreditRequest=" + isValidateCreditRequest +
                ", creditRequest=" + creditRequest +
                ", customerId='" + customerId + '\'' +
                ", isUpdateContract=" + isUpdateContract +
                ", creditResponseDTO=" + creditResponseDTO +
                ", errorCreditResponseDTO=" + errorCreditResponseDTO +
                ", authenticateDTO=" + authenticateDTO +
                ", token=" + token +
                ", creditRequestDTO=" + creditRequestDTO +
                ", creditRequestValidateInfo=" + creditRequestValidateInfo +
                '}';
    }
}
