package pl.aeh.bpmn.credit.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.aeh.bpmn.credit.model.CustomerFinancialData;

@Component
public class CustomerFinancialDataRestClient implements ICustomerFinancialDataRestClient {

    @Value("${url.customer-financial-data-service}")
    private String customerFinancialDataServiceUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public CustomerFinancialData getCustomerFinancialData(String userId) {
        UriComponentsBuilder builder
                = UriComponentsBuilder.fromHttpUrl(customerFinancialDataServiceUrl).queryParam("userId", userId);
        return restTemplate.getForEntity(builder.build().encode().toUri(), CustomerFinancialData.class).getBody();
    }
}
