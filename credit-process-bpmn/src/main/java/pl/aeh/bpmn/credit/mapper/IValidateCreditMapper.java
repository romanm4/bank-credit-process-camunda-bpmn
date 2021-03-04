package pl.aeh.bpmn.credit.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import pl.aeh.bpmn.credit.model.CreditRequestValidateInfo;
import pl.aeh.bpmn.credit.dto.CreditRequestDTO;
import pl.aeh.bpmn.credit.entity.ValidateCreditRequestEntity;
import pl.aeh.bpmn.credit.entity.ValidateCreditResponseEntity;

@Mapper
public interface IValidateCreditMapper {

    IValidateCreditMapper INSTANCE = Mappers.getMapper(IValidateCreditMapper.class);

    @Mappings({
            @Mapping(target = "currencyType", source = "currencyType"),
            @Mapping(target = "accountNumber", source = "accountNumber"),
            @Mapping(target = "creditAmount", source = "creditAmount"),
            @Mapping(target = "lastPayment", source = "lastPayment")
    })
    ValidateCreditRequestEntity mapCreditRequestDTOtoEntity(CreditRequestDTO creditRequestDTO);

    @Mappings({
            @Mapping(target = "valid", source = "valid"),
            @Mapping(target = "updatable", source = "updatable")
    })
    ValidateCreditResponseEntity mapCreditRequestValidateInfoToEntity(CreditRequestValidateInfo creditRequestValidateInfo);
}
