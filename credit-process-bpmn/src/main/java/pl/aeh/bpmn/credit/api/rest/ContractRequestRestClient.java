package pl.aeh.bpmn.credit.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.aeh.bpmn.credit.dto.ContractRequestDTO;

@Component
public class ContractRequestRestClient implements IContractRequestRestClient {

    @Value("${url.create-new-contract}")
    private String createNewContractServiceUrl;

    @Value("${url.update-contract}")
    private String updateContractServiceUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ContractRequestDTO createNewContract(ContractRequestDTO contractRequestDTO) {
        HttpEntity<ContractRequestDTO> entity = new HttpEntity<>(contractRequestDTO);
        return restTemplate.exchange(createNewContractServiceUrl, HttpMethod.POST, entity, ContractRequestDTO.class).getBody();
    }

    @Override
    public ContractRequestDTO updateContract(ContractRequestDTO contractRequestDTO) {
        HttpEntity<ContractRequestDTO> entity = new HttpEntity<>(contractRequestDTO);
        return restTemplate.exchange(updateContractServiceUrl, HttpMethod.POST, entity, ContractRequestDTO.class).getBody();
    }
}
