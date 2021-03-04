package pl.aeh.bpmn.credit.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import pl.aeh.bpmn.credit.model.CustomerFinancialData;
import pl.aeh.bpmn.credit.entity.CustomerFinancialDataRequestEntity;
import pl.aeh.bpmn.credit.entity.CustomerFinancialDataResponseEntity;

@Mapper
public interface ICustomerFinancialDataMapper {

    ICustomerFinancialDataMapper INSTANCE = Mappers.getMapper(ICustomerFinancialDataMapper.class);

    @Mappings({
            @Mapping(target = "customerId", source = "customerId")
    })
    CustomerFinancialDataRequestEntity mapCustomerFinancialDataRequestDTOtoEntity(String customerId);

    @Mappings({
            @Mapping(target = "accountNumber", source = "accountNumber"),
            @Mapping(target = "currencyType", source = "currencyType"),
            @Mapping(target = "amount", source = "amount"),
            @Mapping(target = "creditAccountNumber", source = "creditData.creditAccountNumber"),
            @Mapping(target = "creditAmount", source = "creditData.creditAmount"),
            @Mapping(target = "lastPayment", source = "creditData.lastPayment")
    })
    CustomerFinancialDataResponseEntity mapCustomerFinancialDataDTOtoEntity(CustomerFinancialData customerFinancialDataDTO);
}
