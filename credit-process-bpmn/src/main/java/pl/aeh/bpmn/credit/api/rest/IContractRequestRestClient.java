package pl.aeh.bpmn.credit.api.rest;

import org.springframework.stereotype.Component;
import pl.aeh.bpmn.credit.dto.ContractRequestDTO;

@Component
public interface IContractRequestRestClient {

    ContractRequestDTO createNewContract(ContractRequestDTO contractRequestDTO);

    ContractRequestDTO updateContract(ContractRequestDTO contractRequestDTO);
}
