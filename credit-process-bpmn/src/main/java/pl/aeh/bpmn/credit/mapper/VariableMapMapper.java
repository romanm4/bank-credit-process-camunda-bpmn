package pl.aeh.bpmn.credit.mapper;

import org.camunda.bpm.engine.variable.VariableMap;
import org.springframework.stereotype.Component;
import pl.aeh.bpmn.credit.model.CreditRequestValidateInfo;
import pl.aeh.bpmn.credit.model.CustomerFinancialData;
import pl.aeh.bpmn.credit.model.Token;
import pl.aeh.bpmn.credit.delegate.ProcessDelegate;
import pl.aeh.bpmn.credit.dto.*;
import pl.aeh.bpmn.credit.model.CreditRequest;

@Component
public class VariableMapMapper {

    public ProcessVariableDTO mapProcessVariableToProcessVariableDTO(VariableMap variableMap) {
        ProcessVariableDTO processVariableDTO = new ProcessVariableDTO();
        processVariableDTO.setCreditRequest((CreditRequest) variableMap.get(ProcessDelegate.CREDIT_REQUEST));
        processVariableDTO.setCustomerExist((Boolean) variableMap.get(ProcessDelegate.IS_CUSTOMER_EXIST));
        processVariableDTO.setCustomerFinancialData((CustomerFinancialData) variableMap.get(ProcessDelegate.CUSTOMER_FINANCIAL_DATA));
        processVariableDTO.setCustomerId((String) variableMap.get(ProcessDelegate.CUSTOMER_ID));
        processVariableDTO.setErrorCreditResponseDTO((ErrorCreditResponseDTO) variableMap.get(ProcessDelegate.ERROR_CREDIT_RESPONSE));
        processVariableDTO.setCreditResponseDTO((CreditResponseDTO) variableMap.get(ProcessDelegate.CREDIT_RESPONSE));
        processVariableDTO.setAuthenticateDTO((AuthenticateDTO) variableMap.get(ProcessDelegate.AUTHENTICATE_REQUEST_DTO));
        processVariableDTO.setToken((Token) variableMap.get(ProcessDelegate.AUTHENTICATE_RESPONSE_DTO));
        processVariableDTO.setCreditRequestDTO((CreditRequestDTO) variableMap.get(ProcessDelegate.CREDIT_VALIDATE_REQUEST_DTO));
        processVariableDTO.setCreditRequestValidateInfo((CreditRequestValidateInfo) variableMap.get(ProcessDelegate.CREDIT_VALIDATE_RESPONSE_DTO));
        processVariableDTO.setProcessId((String) variableMap.get(ProcessDelegate.PROCESS_ID));
        return processVariableDTO;
    }
}
