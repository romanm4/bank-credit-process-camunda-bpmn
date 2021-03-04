package pl.aeh.bpmn.credit.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import pl.aeh.bpmn.credit.model.Token;
import pl.aeh.bpmn.credit.dto.AuthenticateDTO;

@Component
public class AuthenticateRestClient implements IAuthenticateRestClient {

    @Value("${url.authentication-service}")
    private String authenticateServiceUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Token authenticate(AuthenticateDTO authenticateDTO) throws HttpClientErrorException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/json");
        HttpEntity<AuthenticateDTO> entity = new HttpEntity<>(authenticateDTO, headers);
        return restTemplate.exchange(authenticateServiceUrl, HttpMethod.POST, entity, Token.class).getBody();
    }
}
