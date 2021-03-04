package pl.aeh.bpmn.credit.delegate;

import org.apache.log4j.Logger;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import pl.aeh.bpmn.credit.api.rest.IAuthenticateRestClient;
import pl.aeh.bpmn.credit.model.Token;
import pl.aeh.bpmn.credit.dto.AuthenticateDTO;
import pl.aeh.bpmn.credit.mapper.IAuthenticateMapper;
import pl.aeh.bpmn.credit.model.CreditRequest;

@Component
public class AuthenticateCustomerDelegate extends ProcessDelegate implements JavaDelegate {

    private static final Logger logger = Logger.getLogger(AuthenticateCustomerDelegate.class);

    @Autowired
    private IAuthenticateRestClient authenticateRestClient;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        logger.info("Execute \"" + delegateExecution.getCurrentActivityName() + "\" step. Process instance id = "
                + delegateExecution.getProcessInstance().getProcessInstanceId());
        delegateExecution.setVariable(PROCESS_ID, delegateExecution.getProcessInstance().getProcessInstanceId());
        CreditRequest creditRequest = getCreditRequestFromDelegateExecution(delegateExecution);
        AuthenticateDTO authenticateDTO = IAuthenticateMapper.INSTANCE.mapCreditRequestToAuthenticateDTO(creditRequest);
        try {
            Token token = authenticateRestClient.authenticate(authenticateDTO);
            boolean isAuthenticate = token.isAuthenticate();
            delegateExecution.setVariable(IS_CUSTOMER_EXIST, isAuthenticate);
            if (isAuthenticate) {
                delegateExecution.setVariable(CUSTOMER_ID, token.getUserId());
                delegateExecution.setVariable(AUTHENTICATE_REQUEST_DTO, authenticateDTO);
                delegateExecution.setVariable(AUTHENTICATE_RESPONSE_DTO, token);
            }
        } catch (HttpClientErrorException e) {
            logger.warn("Execute \"" + delegateExecution.getCurrentActivityName() + "\" step. Unauthorized.");
            delegateExecution.setVariable(IS_CUSTOMER_EXIST, false);
        } catch (Exception e) {
            logger.error("Execute \"" + delegateExecution.getCurrentActivityName() + "\" step. Error ");
        }
    }
}
