package pl.aeh.bpmn.credit.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import pl.aeh.bpmn.credit.model.CustomerFinancialData;
import pl.aeh.bpmn.credit.model.CreditRequest;

public abstract class ProcessDelegate {

    public static final String CREDIT_REQUEST = "creditRequest";
    public static final String CUSTOMER_FINANCIAL_DATA = "customerFinancialData";
    public static final String IS_CUSTOMER_EXIST = "isCustomerExist";
    public static final String CUSTOMER_ID = "customerId";
    public static final String IS_VALIDATE_CREDIT_REQUEST = "isValidateCreditRequest";
    public static final String IS_UPDATE_CONTRACT = "isUpdateContract";
    public static final String ERROR_CREDIT_RESPONSE = "errorCreditResponse";
    public static final String CREDIT_RESPONSE = "creditResponse";
    public static final String ERROR_TYPE = "errorType";
    public static final String AUTHENTICATE_REQUEST_DTO = "authenticateDTO";
    public static final String AUTHENTICATE_RESPONSE_DTO = "token";
    public static final String CREDIT_VALIDATE_REQUEST_DTO = "creditRequestDTO";
    public static final String CREDIT_VALIDATE_RESPONSE_DTO = "creditRequestValidateInfo";
    public static final String PROCESS_ID = "processId";

    protected CreditRequest getCreditRequestFromDelegateExecution(DelegateExecution delegateExecution) {
        return (CreditRequest) delegateExecution.getVariable(CREDIT_REQUEST);
    }

    protected CustomerFinancialData getCustomerFinancialDataFromDelegateExecution(DelegateExecution delegateExecution) {
        return (CustomerFinancialData) delegateExecution.getVariable(CUSTOMER_FINANCIAL_DATA);
    }
}
