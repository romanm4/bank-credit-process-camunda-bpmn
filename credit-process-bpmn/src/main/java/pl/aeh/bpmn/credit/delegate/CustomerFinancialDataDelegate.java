package pl.aeh.bpmn.credit.delegate;

import org.apache.log4j.Logger;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.aeh.bpmn.credit.api.rest.ICustomerFinancialDataRestClient;
import pl.aeh.bpmn.credit.model.CustomerFinancialData;

@Component
public class CustomerFinancialDataDelegate extends ProcessDelegate implements JavaDelegate {

    private static final Logger logger = Logger.getLogger(CustomerFinancialDataDelegate.class);

    @Autowired
    private ICustomerFinancialDataRestClient customerFinancialDataRestClient;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        logger.info("Execute \"" + delegateExecution.getCurrentActivityName() + "\" step. Process instance id = "
                + delegateExecution.getProcessInstance().getProcessInstanceId());
        CustomerFinancialData customerFinancialData = customerFinancialDataRestClient.getCustomerFinancialData(
                delegateExecution.getVariable(CUSTOMER_ID).toString()
        );
        delegateExecution.setVariable(CUSTOMER_FINANCIAL_DATA, customerFinancialData);
    }
}
