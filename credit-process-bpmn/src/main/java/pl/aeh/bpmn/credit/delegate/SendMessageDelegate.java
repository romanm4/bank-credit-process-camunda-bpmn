package pl.aeh.bpmn.credit.delegate;

import org.apache.log4j.Logger;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import pl.aeh.bpmn.credit.dto.ContractRequestDTO;
import pl.aeh.bpmn.credit.dto.CreditResponseDTO;
import pl.aeh.bpmn.credit.dto.ErrorCreditResponseDTO;
import pl.aeh.bpmn.credit.jms.JmsContractProducer;

import java.util.Objects;


@Component
@PropertySource(value = "classpath:error.properties")
public class SendMessageDelegate extends ProcessDelegate implements JavaDelegate {

    private static final Logger logger = Logger.getLogger(SendMessageDelegate.class);

    @Value("${error.message.authenticate}")
    private String authenticateErrorMessage;

    @Value("${error.message.rejected}")
    private String errorMessageRejected;

    @Autowired
    private JmsContractProducer jmsContractProducer;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        logger.info("Execute \"" + delegateExecution.getCurrentActivityName() + "\" step. Process instance id = "
                + delegateExecution.getProcessInstance().getProcessInstanceId());
        ErrorCreditResponseDTO.ErrorType errorType
                = (ErrorCreditResponseDTO.ErrorType) delegateExecution.getVariable(ERROR_TYPE);
        ErrorCreditResponseDTO errorCreditResponseDTO = new ErrorCreditResponseDTO();
        errorCreditResponseDTO.setErrorType(errorType);

        boolean isCustomerExist = (boolean) delegateExecution.getVariable(IS_CUSTOMER_EXIST);

        if (!isCustomerExist) {
            errorCreditResponseDTO.setErrorType(ErrorCreditResponseDTO.ErrorType.UNAUTHORIZED);
            errorCreditResponseDTO.setErrorMessage(authenticateErrorMessage);
            delegateExecution.setVariable(ERROR_CREDIT_RESPONSE, errorCreditResponseDTO);
        } else {
            if (Objects.nonNull(delegateExecution.getVariable(IS_VALIDATE_CREDIT_REQUEST))) {
                boolean isValidateCreditRequest = (boolean) delegateExecution.getVariable(IS_VALIDATE_CREDIT_REQUEST);
                if (isValidateCreditRequest) {
                    if (Objects.nonNull(delegateExecution.getVariable(IS_UPDATE_CONTRACT))) {
                        boolean isUpdateContract = (boolean) delegateExecution.getVariable(IS_UPDATE_CONTRACT);
                        if (isUpdateContract) {
                            delegateExecution.setVariable(CREDIT_RESPONSE, new CreditResponseDTO("Credit contract sent to update"));
                        } else {
                            delegateExecution.setVariable(CREDIT_RESPONSE, new CreditResponseDTO("Credit contract sent to create"));
                        }
                    }
                } else {
                    errorCreditResponseDTO.setErrorType(ErrorCreditResponseDTO.ErrorType.REJECT);
                    errorCreditResponseDTO.setErrorMessage(errorMessageRejected);
                    delegateExecution.setVariable(ERROR_CREDIT_RESPONSE, errorCreditResponseDTO);
                }
            }
            ContractRequestDTO creditRequestDTO = (ContractRequestDTO) delegateExecution.getVariable(CREDIT_REQUEST);
            jmsContractProducer.sendContractToQueue(creditRequestDTO);
        }
    }
}
