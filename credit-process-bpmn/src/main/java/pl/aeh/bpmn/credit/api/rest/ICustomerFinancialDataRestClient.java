package pl.aeh.bpmn.credit.api.rest;

import org.springframework.stereotype.Component;
import pl.aeh.bpmn.credit.model.CustomerFinancialData;

@Component
public interface ICustomerFinancialDataRestClient {
    CustomerFinancialData getCustomerFinancialData(String userId);
}
