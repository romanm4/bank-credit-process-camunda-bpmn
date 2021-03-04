package pl.aeh.bpmn.credit.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.aeh.bpmn.credit.model.CreditRequestValidateInfo;
import pl.aeh.bpmn.credit.dto.CreditRequestDTO;

@Component
public class ValidateCreditRequestRestClient implements IValidateCreditRequestRestClient {

    @Value("${url.validate-credit-request}")
    private String validateCreditRequestServiceUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public CreditRequestValidateInfo validateCreditRequest(CreditRequestDTO creditRequestDTO) {
        HttpEntity<CreditRequestDTO> entity = new HttpEntity<>(creditRequestDTO);
        return restTemplate.exchange(validateCreditRequestServiceUrl, HttpMethod.POST, entity, CreditRequestValidateInfo.class).getBody();
    }
}
