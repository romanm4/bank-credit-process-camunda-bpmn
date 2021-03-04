package pl.aeh.bpmn.credit.delegate;

import org.apache.log4j.Logger;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.aeh.bpmn.credit.api.rest.IValidateCreditRequestRestClient;
import pl.aeh.bpmn.credit.model.CreditRequestValidateInfo;
import pl.aeh.bpmn.credit.model.CustomerFinancialData;
import pl.aeh.bpmn.credit.dto.CreditRequestDTO;
import pl.aeh.bpmn.credit.mapper.ICreditRequestMapper;

import java.util.Objects;

@Component
public class ValidateClientCreditRequestDelegate extends ProcessDelegate implements JavaDelegate {

    private static final Logger logger = Logger.getLogger(ValidateClientCreditRequestDelegate.class);

    @Autowired
    private IValidateCreditRequestRestClient validateCreditRequestRestClient;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        logger.info("Execute \"" + delegateExecution.getCurrentActivityName() + "\" step. Process instance id = "
                + delegateExecution.getProcessInstance().getProcessInstanceId());
        CustomerFinancialData customerFinancialData = getCustomerFinancialDataFromDelegateExecution(delegateExecution);
        if (Objects.nonNull(customerFinancialData)) {
            CreditRequestDTO creditRequestDTO
                    = ICreditRequestMapper.INSTANCE.mapCustomerFinancialDataToCreditRequestDTO(customerFinancialData);
            CreditRequestValidateInfo creditRequestValidateInfo
                    = validateCreditRequestRestClient.validateCreditRequest(creditRequestDTO);
            if (creditRequestValidateInfo.isValid()) {
                logger.info("\"Execute \"" + delegateExecution.getCurrentActivityName() + "\" step. Client credit was validated.");
            } else {
                logger.info("\"Execute \"" + delegateExecution.getCurrentActivityName() + "\" step. Client credit wasn't validated.");
            }
            delegateExecution.setVariable(IS_VALIDATE_CREDIT_REQUEST, creditRequestValidateInfo.isValid());
            delegateExecution.setVariable(IS_UPDATE_CONTRACT, creditRequestValidateInfo.isUpdatable());
            delegateExecution.setVariable(CREDIT_VALIDATE_REQUEST_DTO, creditRequestDTO);
            delegateExecution.setVariable(CREDIT_VALIDATE_RESPONSE_DTO, creditRequestValidateInfo);
        } else {
            delegateExecution.setVariable(IS_VALIDATE_CREDIT_REQUEST, false);
            delegateExecution.setVariable(IS_UPDATE_CONTRACT, false);
        }
    }
}
