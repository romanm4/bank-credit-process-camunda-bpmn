package pl.aeh.bpmn.credit.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstanceWithVariables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.aeh.bpmn.credit.delegate.ProcessDelegate;
import pl.aeh.bpmn.credit.dto.ProcessVariableDTO;
import pl.aeh.bpmn.credit.mapper.VariableMapMapper;
import pl.aeh.bpmn.credit.model.*;
import pl.aeh.bpmn.credit.service.CreditRequestProcessService;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping(value = "bankCredit")
public class BankCreditProcessController {

    private static final Logger logger = Logger.getLogger(BankCreditProcessController.class);

    private static final String PROCESS_KEY = "bankCreditServiceId";

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private VariableMapMapper variableMapMapper;

    @Autowired
    private CreditRequestProcessService creditRequestProcessService;

    @PostMapping(value = "/sendCreditRequest",
            headers = "Accept=*/*",
            produces = "application/json",
            consumes="application/json")
    public ResponseEntity<?> sendCreditRequestToProcess(@RequestBody CreditRequest creditRequest) throws IOException {
        logger.info("Start send credit request to process. Request body: \n" + creditRequest.toString());
        Map<String, Object> variables = new HashMap<>();
        variables.put(ProcessDelegate.CREDIT_REQUEST, creditRequest);

        ProcessInstanceWithVariables instance
                = (ProcessInstanceWithVariables) runtimeService.startProcessInstanceByKey(PROCESS_KEY, variables);

        ProcessVariableDTO processVariableDTO
                = variableMapMapper.mapProcessVariableToProcessVariableDTO(instance.getVariables());

        if (Objects.nonNull(processVariableDTO.getCreditResponseDTO())) {
            creditRequestProcessService.saveProcessInfo(processVariableDTO);
            return ResponseEntity.ok(processVariableDTO.getCreditResponseDTO());
        } else {
            if (Objects.nonNull(processVariableDTO.getErrorCreditResponseDTO())) {
                return ResponseEntity.ok(processVariableDTO.getErrorCreditResponseDTO());
            }
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
