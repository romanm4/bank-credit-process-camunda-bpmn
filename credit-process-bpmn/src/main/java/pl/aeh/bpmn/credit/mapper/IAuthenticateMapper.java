package pl.aeh.bpmn.credit.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import pl.aeh.bpmn.credit.model.Token;
import pl.aeh.bpmn.credit.dto.AuthenticateDTO;
import pl.aeh.bpmn.credit.entity.AuthenticateCustomerRequestEntity;
import pl.aeh.bpmn.credit.entity.AuthenticateCustomerResponseEntity;
import pl.aeh.bpmn.credit.model.CreditRequest;

@Mapper
public interface IAuthenticateMapper {

    IAuthenticateMapper INSTANCE = Mappers.getMapper(IAuthenticateMapper.class);

    @Mappings({
            @Mapping(target= "passport", source = "customerDetails.passportNumber"),
            @Mapping(target = "account", source = "bankDetails.accountNumber"),
            @Mapping(target = "firstName", source = "customerDetails.firstName"),
            @Mapping(target = "lastName", source = "customerDetails.lastName"),
            @Mapping(target = "phone", source = "customerDetails.phone")
    })
    AuthenticateDTO mapCreditRequestToAuthenticateDTO(CreditRequest creditRequest);

    @Mappings({
            @Mapping(target = "passport", source = "passport"),
            @Mapping(target = "account", source = "account"),
            @Mapping(target = "firstName", source = "firstName"),
            @Mapping(target = "lastName", source = "lastName"),
            @Mapping(target = "phone", source = "phone"),
    })
    AuthenticateCustomerRequestEntity mapAuthenticateCustomerRequestDTOtoEntity(AuthenticateDTO authenticateDTO);

    @Mappings({
            @Mapping(target = "authenticate", source = "authenticate"),
            @Mapping(target = "userId", source = "userId"),
    })
    AuthenticateCustomerResponseEntity mapTokenDTOtoAuthenticateCustomerResponseEntity(Token tokenDTO);
}
