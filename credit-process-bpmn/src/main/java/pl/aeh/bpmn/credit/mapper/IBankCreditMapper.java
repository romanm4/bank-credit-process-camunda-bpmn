package pl.aeh.bpmn.credit.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import pl.aeh.bpmn.credit.dto.CreditResponseDTO;
import pl.aeh.bpmn.credit.entity.BankCreditRequestEntity;
import pl.aeh.bpmn.credit.entity.BankCreditResponseEntity;
import pl.aeh.bpmn.credit.model.CreditRequest;

@Mapper
public interface IBankCreditMapper {

    IBankCreditMapper INSTANCE = Mappers.getMapper(IBankCreditMapper.class);

    @Mappings({
            @Mapping(target = "date", source = "date"),
            @Mapping(target = "amountOfCreditRequested", source = "amountOfCreditRequested"),
            @Mapping(target = "customerFirstName", source = "customerDetails.firstName"),
            @Mapping(target = "customerLastName", source = "customerDetails.lastName"),
            @Mapping(target = "customerPassportNumber", source = "customerDetails.passportNumber"),
            @Mapping(target = "customerPhone", source = "customerDetails.phone"),
            @Mapping(target = "customerEmail", source = "customerDetails.email"),
            @Mapping(target = "customerAddress", expression= "java(creditRequest.getCustomerDetails().getAddress().getCountry() " +
                    "+ \" \" + creditRequest.getCustomerDetails().getAddress().getCity()" +
                    "+ \" \" + creditRequest.getCustomerDetails().getAddress().getStreet()" +
                    "+ \" \" + creditRequest.getCustomerDetails().getAddress().getHouseNumber()" +
                    "+ \" \" + creditRequest.getCustomerDetails().getAddress().getFlatNumber())"),
            @Mapping(target = "bankName", source = "bankDetails.bankName"),
            @Mapping(target = "bankAddress", expression= "java(creditRequest.getBankDetails().getAddress().getCountry() " +
                    "+ \" \" + creditRequest.getBankDetails().getAddress().getCity()" +
                    "+ \" \" + creditRequest.getBankDetails().getAddress().getStreet()" +
                    "+ \" \" + creditRequest.getBankDetails().getAddress().getHouseNumber()" +
                    "+ \" \" + creditRequest.getBankDetails().getAddress().getFlatNumber())"),
            @Mapping(target = "accountNumber", source = "bankDetails.accountNumber"),
            @Mapping(target = "bankPhone", source = "bankDetails.phone"),
            @Mapping(target = "bankEmail", source = "bankDetails.email"),
            @Mapping(target = "proposedCreditMethodPayment", source = "proposedCreditMethodPayment"),
            @Mapping(target = "percent", source = "percent"),
            @Mapping(target = "additionalInformation", source = "additionalInformation")
    })
    BankCreditRequestEntity mapBankCreditRequestDTOtoEntity(CreditRequest creditRequest);

    @Mappings({
            @Mapping(target = "status", source = "status")
    })
    BankCreditResponseEntity mapCreditResponseDTOtoEntity(CreditResponseDTO creditResponseDTO);

}
