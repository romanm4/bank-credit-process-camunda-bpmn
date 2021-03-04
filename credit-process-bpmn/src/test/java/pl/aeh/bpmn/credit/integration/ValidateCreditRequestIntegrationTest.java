package pl.aeh.bpmn.credit.integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import pl.aeh.bpmn.credit.model.CreditRequestValidateInfo;
import pl.aeh.bpmn.credit.dto.CreditRequestDTO;

import java.math.BigDecimal;
import java.util.Objects;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ValidateCreditRequestIntegrationTest {

    @LocalServerPort
    private int port;

    @Value("${url.validate-credit-request}")
    private String validateCreditRequestServiceUrl;

    TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void testIsValidCreditRequest() {
        CreditRequestDTO creditRequestDTO = new CreditRequestDTO(
                "USD",
                "111222333444555666777888999",
                new BigDecimal(1000.0),
                new BigDecimal(100.0)
        );
        HttpEntity<CreditRequestDTO> entity = new HttpEntity<>(creditRequestDTO);
        CreditRequestValidateInfo creditRequestValidateInfo =
                restTemplate.exchange(validateCreditRequestServiceUrl, HttpMethod.POST, entity, CreditRequestValidateInfo.class).getBody();
        assert Objects.nonNull(creditRequestValidateInfo);
        assert !creditRequestValidateInfo.isUpdatable();
    }

    @Test
    public void testIsNotValidCreditRequest() {
        CreditRequestDTO creditRequestDTO = new CreditRequestDTO(
                "PLN",
                "111222333444555666777888999",
                new BigDecimal(1000.0),
                new BigDecimal(100.0)
        );
        HttpEntity<CreditRequestDTO> entity = new HttpEntity<>(creditRequestDTO);
        CreditRequestValidateInfo creditRequestValidateInfo =
                restTemplate.exchange(validateCreditRequestServiceUrl, HttpMethod.POST, entity, CreditRequestValidateInfo.class).getBody();
        assert Objects.nonNull(creditRequestValidateInfo);
        assert creditRequestValidateInfo.isUpdatable();
    }
}
