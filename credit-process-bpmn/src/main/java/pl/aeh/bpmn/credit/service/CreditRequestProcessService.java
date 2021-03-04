package pl.aeh.bpmn.credit.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.aeh.bpmn.credit.dto.ProcessVariableDTO;
import pl.aeh.bpmn.credit.entity.*;
import pl.aeh.bpmn.credit.mapper.*;
import pl.aeh.bpmn.credit.repository.*;
import javax.transaction.Transactional;

@Service
public class CreditRequestProcessService {

    private static final Logger logger = Logger.getLogger(CreditRequestProcessService.class);

    @Autowired
    private IAuthenticateCustomerRequestRepository iAuthenticateCustomerRequestRepository;

    @Autowired
    private IAuthenticateCustomerRequestResponseRepository iAuthenticateCustomerRequestResponseRepository;

    @Autowired
    private IAuthenticateCustomerResponseRepository iAuthenticateCustomerResponseRepository;

    @Autowired
    private IBankCreditRequestRepository iBankCreditRequestRepository;

    @Autowired
    private IBankCreditRequestResponseRepository iBankCreditRequestResponseRepository;

    @Autowired
    private IBankCreditResponseRepository iBankCreditResponseRepository;

    @Autowired
    private IContractRequestRepository iContractRequestRepository;

    @Autowired
    private ICustomerFinancialDataRequestRepository iCustomerFinancialDataRequestRepository;

    @Autowired
    private ICustomerFinancialDataRequestResponseRepository iCustomerFinancialDataRequestResponseRepository;

    @Autowired
    private ICustomerFinancialDataResponseRepository iCustomerFinancialDataResponseRepository;

    @Autowired
    private IValidateCreditRequestRepository iValidateCreditRequestRepository;

    @Autowired
    private IValidateCreditRequestResponseRepository iValidateCreditRequestResponseRepository;

    @Autowired
    private IValidateCreditResponseRepository iValidateCreditResponseRepository;

    public void saveProcessInfo(ProcessVariableDTO processVariableDTO) {
        logger.info("Save process context to database.");
        saveAuthenticateCustomerRequest(processVariableDTO);
        saveValidateCreditRequest(processVariableDTO);
        saveBankCreditRequestEntity(processVariableDTO);
        saveCustomerFinancialDataRequest(processVariableDTO);
    }

    @Transactional
    private void saveAuthenticateCustomerRequest(ProcessVariableDTO processVariableDTO) {
        AuthenticateCustomerRequestResponseEntity authenticateCustomerRequestResponseEntity =
                new AuthenticateCustomerRequestResponseEntity();
        authenticateCustomerRequestResponseEntity.setProcessId(processVariableDTO.getProcessId());
        AuthenticateCustomerRequestEntity authenticateCustomerRequestEntity
                = IAuthenticateMapper.INSTANCE.mapAuthenticateCustomerRequestDTOtoEntity(processVariableDTO.getAuthenticateDTO());
        AuthenticateCustomerResponseEntity authenticateCustomerResponseEntity
                = IAuthenticateMapper.INSTANCE.mapTokenDTOtoAuthenticateCustomerResponseEntity(processVariableDTO.getToken());
        authenticateCustomerRequestResponseEntity.setAuthenticateCustomerRequest(authenticateCustomerRequestEntity);
        authenticateCustomerRequestResponseEntity.setAuthenticateCustomerResponse(authenticateCustomerResponseEntity);

        iAuthenticateCustomerRequestRepository.save(authenticateCustomerRequestEntity);
        iAuthenticateCustomerResponseRepository.save(authenticateCustomerResponseEntity);
        iAuthenticateCustomerRequestResponseRepository.save(authenticateCustomerRequestResponseEntity);
    }

    @Transactional
    private void saveValidateCreditRequest(ProcessVariableDTO processVariableDTO) {
        ValidateCreditRequestResponseEntity validateCreditRequestResponseEntity =
                new ValidateCreditRequestResponseEntity();
        validateCreditRequestResponseEntity.setProcessId(processVariableDTO.getProcessId());
        ValidateCreditRequestEntity validateCreditRequestEntity =
                IValidateCreditMapper.INSTANCE.mapCreditRequestDTOtoEntity(processVariableDTO.getCreditRequestDTO());
        ValidateCreditResponseEntity validateCreditResponseEntity =
                IValidateCreditMapper.INSTANCE.mapCreditRequestValidateInfoToEntity(processVariableDTO.getCreditRequestValidateInfo());
        validateCreditRequestResponseEntity.setValidateCreditRequest(validateCreditRequestEntity);
        validateCreditRequestResponseEntity.setValidateCreditResponse(validateCreditResponseEntity);

        iValidateCreditRequestRepository.save(validateCreditRequestEntity);
        iValidateCreditResponseRepository.save(validateCreditResponseEntity);
        iValidateCreditRequestResponseRepository.save(validateCreditRequestResponseEntity);
    }

    @Transactional
    private void saveBankCreditRequestEntity(ProcessVariableDTO processVariableDTO) {
        BankCreditRequestResponseEntity bankCreditRequestResponseEntity =
                new BankCreditRequestResponseEntity();
        bankCreditRequestResponseEntity.setProcessId(processVariableDTO.getProcessId());
        BankCreditRequestEntity bankCreditRequestEntity
                = IBankCreditMapper.INSTANCE.mapBankCreditRequestDTOtoEntity(processVariableDTO.getCreditRequest());
        BankCreditResponseEntity bankCreditResponseEntity =
                IBankCreditMapper.INSTANCE.mapCreditResponseDTOtoEntity(processVariableDTO.getCreditResponseDTO());
        ContractRequestEntity contractRequestEntity
                = ICreditRequestMapper.INSTANCE.mapContractRequestDTOtoEntity(processVariableDTO.getCreditRequest());
        bankCreditRequestResponseEntity.setBankCreditRequest(bankCreditRequestEntity);
        bankCreditRequestResponseEntity.setBankCreditResponse(bankCreditResponseEntity);
        bankCreditRequestResponseEntity.setContractRequest(contractRequestEntity);

        iBankCreditRequestRepository.save(bankCreditRequestEntity);
        iBankCreditResponseRepository.save(bankCreditResponseEntity);
        iContractRequestRepository.save(contractRequestEntity);
        iBankCreditRequestResponseRepository.save(bankCreditRequestResponseEntity);
    }

    @Transactional
    private void saveCustomerFinancialDataRequest(ProcessVariableDTO processVariableDTO) {
        CustomerFinancialDataRequestResponseEntity customerFinancialDataRequestResponseEntity =
                new CustomerFinancialDataRequestResponseEntity();
        customerFinancialDataRequestResponseEntity.setProcessId(processVariableDTO.getProcessId());
        CustomerFinancialDataRequestEntity customerFinancialDataRequestEntity
                = ICustomerFinancialDataMapper.INSTANCE.mapCustomerFinancialDataRequestDTOtoEntity(processVariableDTO.getCustomerId());
        CustomerFinancialDataResponseEntity customerFinancialDataResponseEntity
                = ICustomerFinancialDataMapper.INSTANCE.mapCustomerFinancialDataDTOtoEntity(processVariableDTO.getCustomerFinancialData());
        customerFinancialDataRequestResponseEntity.setCustomerFinancialDataRequest(customerFinancialDataRequestEntity);
        customerFinancialDataRequestResponseEntity.setCustomerFinancialDataResponse(customerFinancialDataResponseEntity);

        iCustomerFinancialDataRequestRepository.save(customerFinancialDataRequestEntity);
        iCustomerFinancialDataResponseRepository.save(customerFinancialDataResponseEntity);
        iCustomerFinancialDataRequestResponseRepository.save(customerFinancialDataRequestResponseEntity);
    }
}
