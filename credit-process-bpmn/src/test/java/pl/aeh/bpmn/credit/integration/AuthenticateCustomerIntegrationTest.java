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
import pl.aeh.bpmn.credit.model.Token;
import pl.aeh.bpmn.credit.dto.AuthenticateDTO;

import java.util.Objects;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AuthenticateCustomerIntegrationTest {

    @LocalServerPort
    private int port;

    @Value("${url.authentication-service}")
    private String authenticateServiceUrl;

    TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void testSuccessAuthenticate() {
        AuthenticateDTO authenticateDTO = new AuthenticateDTO(
                "RP99887117",
                "Yan",
                "Kowalski",
                "48777888999",
                "111222333444555666777888999"
        );
        HttpEntity<AuthenticateDTO> entity = new HttpEntity<>(authenticateDTO);
        Token token = restTemplate.exchange(authenticateServiceUrl, HttpMethod.POST, entity, Token.class).getBody();
        if (Objects.nonNull(token))
            assert token.isAuthenticate();
        else
            assert false;
    }

    @Test
    public void testFailAuthenticate() {
        AuthenticateDTO authenticateDTO = new AuthenticateDTO(
                "RP99887712",
                "Yan",
                "Kowalski",
                "48777888999",
                "111222333444555666777888999"
        );
        HttpEntity<AuthenticateDTO> entity = new HttpEntity<>(authenticateDTO);
        Token token = restTemplate.exchange(authenticateServiceUrl, HttpMethod.POST, entity, Token.class).getBody();
        if (Objects.nonNull(token))
            assert !token.isAuthenticate();
        else
            assert true;
    }
}
