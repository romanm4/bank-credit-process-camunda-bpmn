package pl.aeh.bpmn.credit.api.rest;

import org.springframework.stereotype.Component;
import pl.aeh.bpmn.credit.model.Token;
import pl.aeh.bpmn.credit.dto.AuthenticateDTO;

@Component
public interface IAuthenticateRestClient {
    Token authenticate(AuthenticateDTO authenticateDTO);
}
