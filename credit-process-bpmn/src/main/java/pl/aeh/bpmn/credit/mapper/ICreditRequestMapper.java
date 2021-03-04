package pl.aeh.bpmn.credit.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import pl.aeh.bpmn.credit.model.CustomerFinancialData;
import pl.aeh.bpmn.credit.dto.CreditRequestDTO;
import pl.aeh.bpmn.credit.entity.ContractRequestEntity;
import pl.aeh.bpmn.credit.model.CreditRequest;

@Mapper
public interface ICreditRequestMapper {

    ICreditRequestMapper INSTANCE = Mappers.getMapper(ICreditRequestMapper.class);

    @Mappings({
            @Mapping(target= "currencyType", source= "currencyType"),
            @Mapping(target = "accountNumber", source = "accountNumber"),
            @Mapping(target = "creditAmount", source = "creditData.creditAmount"),
            @Mapping(target = "lastPayment", source = "creditData.lastPayment"),
    })
    CreditRequestDTO mapCustomerFinancialDataToCreditRequestDTO(CustomerFinancialData customerFinancialData);

    @Mappings({
            @Mapping(target= "date", source= "date"),
            @Mapping(target= "loanAmount", source= "amountOfCreditRequested"),
            @Mapping(target= "firstName", source= "customerDetails.firstName"),
            @Mapping(target= "lastName", source= "customerDetails.lastName"),
            @Mapping(target= "address", expression= "java(creditRequestDTO.getCustomerDetails().getAddress().getCountry() " +
                    "+ \" \" + creditRequestDTO.getCustomerDetails().getAddress().getCity()" +
                    "+ \" \" + creditRequestDTO.getCustomerDetails().getAddress().getStreet()" +
                    "+ \" \" + creditRequestDTO.getCustomerDetails().getAddress().getHouseNumber()" +
                    "+ \" \" + creditRequestDTO.getCustomerDetails().getAddress().getFlatNumber())"),
            @Mapping(target= "percent", source= "percent"),
            @Mapping(target= "additionalInformation", source= "additionalInformation")
    })
    ContractRequestEntity mapContractRequestDTOtoEntity(CreditRequest creditRequestDTO);
}
