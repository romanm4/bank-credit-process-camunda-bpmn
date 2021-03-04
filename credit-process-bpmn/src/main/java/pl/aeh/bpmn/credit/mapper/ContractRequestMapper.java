package pl.aeh.bpmn.credit.mapper;

import org.springframework.stereotype.Component;
import pl.aeh.bpmn.credit.dto.ContractRequestDTO;
import pl.aeh.bpmn.credit.model.Address;
import pl.aeh.bpmn.credit.model.CreditRequest;

@Component
public class ContractRequestMapper {

    public ContractRequestDTO mapCreditRequestToContractRequestDTO(CreditRequest creditRequest) {
        ContractRequestDTO contractRequestDTO = new ContractRequestDTO();
        contractRequestDTO.setLoanAmount(creditRequest.getAmountOfCreditRequested());
        contractRequestDTO.setDate(creditRequest.getDate());
        contractRequestDTO.setFirstName(creditRequest.getCustomerDetails().getFirstName());
        contractRequestDTO.setLastName(creditRequest.getCustomerDetails().getLastName());
        contractRequestDTO.setPercent(creditRequest.getPercent());
        contractRequestDTO.setProposedCreditMethodPayment(String.valueOf(creditRequest.getProposedCreditMethodPayment()));
        contractRequestDTO.setAdditionalInformation(creditRequest.getAdditionalInformation());
        contractRequestDTO.setAddress(prepareACustomerAddress(creditRequest.getCustomerDetails().getAddress()));
        return contractRequestDTO;
    }

    private String prepareACustomerAddress(Address address) {
        return new StringBuilder()
                .append(address.getCountry())
                .append(", ")
                .append(address.getCity())
                .append(", ")
                .append(address.getStreet())
                .append(", ")
                .append(address.getHouseNumber())
                .append(", ")
                .append(address.getFlatNumber()).toString();
    }
}
