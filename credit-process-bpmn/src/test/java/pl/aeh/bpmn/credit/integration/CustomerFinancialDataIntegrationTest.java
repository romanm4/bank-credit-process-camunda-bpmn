package pl.aeh.bpmn.credit.integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.UriComponentsBuilder;
import pl.aeh.bpmn.credit.model.CustomerFinancialData;

import java.util.Objects;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerFinancialDataIntegrationTest {

    @LocalServerPort
    private int port;

    @Value("${url.customer-financial-data-service}")
    private String customerFinancialDataServiceUrl;

    TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void testGetCustomerFinancialData() {
        String userId = "111222333";
        UriComponentsBuilder builder
                = UriComponentsBuilder.fromHttpUrl(customerFinancialDataServiceUrl).queryParam("userId", userId);
        CustomerFinancialData customerFinancialData
                = restTemplate.getForEntity(builder.build().encode().toUri(), CustomerFinancialData.class).getBody();
        assert Objects.nonNull(customerFinancialData);
    }

    @Test
    public void testNotGetCustomerFinancialData() {
        String userId = "111222334";
        UriComponentsBuilder builder
                = UriComponentsBuilder.fromHttpUrl(customerFinancialDataServiceUrl).queryParam("userId", userId);
        CustomerFinancialData customerFinancialData
                = restTemplate.getForEntity(builder.build().encode().toUri(), CustomerFinancialData.class).getBody();
        assert Objects.isNull(customerFinancialData);
    }
}
