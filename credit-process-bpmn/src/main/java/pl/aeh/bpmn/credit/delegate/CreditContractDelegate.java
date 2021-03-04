package pl.aeh.bpmn.credit.delegate;

import org.apache.log4j.Logger;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.aeh.bpmn.credit.api.rest.IContractRequestRestClient;
import pl.aeh.bpmn.credit.dto.ContractRequestDTO;
import pl.aeh.bpmn.credit.jms.JmsContractProducer;
import pl.aeh.bpmn.credit.mapper.ContractRequestMapper;
import pl.aeh.bpmn.credit.mapper.VariableMapMapper;
import pl.aeh.bpmn.credit.model.CreditRequest;

@Component
public class CreditContractDelegate extends ProcessDelegate implements JavaDelegate {

    private static final Logger logger = Logger.getLogger(CreditContractDelegate.class);

    @Autowired
    private ContractRequestMapper contractRequestMapper;

    @Autowired
    private IContractRequestRestClient contractRequestRestClient;

    @Autowired
    private VariableMapMapper variableMapMapper;

    @Autowired
    private JmsContractProducer jmsContractProducer;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        logger.info("Execute \"" + delegateExecution.getCurrentActivityName() + "\" step. Process instance id = "
                + delegateExecution.getProcessInstance().getProcessInstanceId());
        CreditRequest creditRequest = getCreditRequestFromDelegateExecution(delegateExecution);
        ContractRequestDTO contractRequestDTO = contractRequestMapper.mapCreditRequestToContractRequestDTO(creditRequest);
        if ((Boolean) delegateExecution.getVariable(ProcessDelegate.IS_UPDATE_CONTRACT)) {
            contractRequestDTO = contractRequestRestClient.updateContract(contractRequestDTO);
            logger.info("Execute \"" + delegateExecution.getCurrentActivityName() + "\" step. Create update: \n" + contractRequestDTO.toString());
        } else {
            contractRequestDTO = contractRequestRestClient.createNewContract(contractRequestDTO);
            logger.info("Execute \"" + delegateExecution.getCurrentActivityName() + "\" step. Create new contract: \n" + contractRequestDTO.toString());
        }
        delegateExecution.setVariable(CREDIT_RESPONSE, contractRequestDTO);
    }
}
