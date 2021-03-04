package pl.aeh.bpmn.credit.api.rest;

import org.springframework.stereotype.Component;
import pl.aeh.bpmn.credit.model.CreditRequestValidateInfo;
import pl.aeh.bpmn.credit.dto.CreditRequestDTO;

@Component
public interface IValidateCreditRequestRestClient {
    CreditRequestValidateInfo validateCreditRequest(CreditRequestDTO creditRequestDTO);
}
