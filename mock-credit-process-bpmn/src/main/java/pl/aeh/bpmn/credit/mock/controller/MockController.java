package pl.aeh.bpmn.credit.mock.controller;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.aeh.bpmn.credit.mock.model.*;
import javax.websocket.server.PathParam;
import java.math.BigDecimal;

@RestController
@RequestMapping(value = "mockAuthenticate")
@PropertySource(value = "classpath:authenticate-mock.properties")
public class MockController {

    private static final Logger logger = Logger.getLogger(MockController.class);

    @PostMapping(value = "/authenticate", headers = "Accept=*/*", produces = "application/json", consumes="application/json")
    public ResponseEntity<Token> authenticate(@RequestBody Authenticate authenticate) {
        if (authenticate.getPassport().equals("RP99887117")) {
            Token token = new Token(true, "111222333");
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @GetMapping(value = "/customerFinancialData", headers = "Accept=*/*", produces = "application/json")
    public ResponseEntity<CustomerFinancialData> getCustomerFinancialData(@PathParam(value = "userId") String userId) {
        if (userId.equals("111222333")) {
            CreditData creditData = new CreditData(
                    "12345678900987654321",
                    new BigDecimal(1000000.234),
                    new BigDecimal(170.9)
            );
            CustomerFinancialData customerFinancialData = new CustomerFinancialData(
                    "951357456258", "PLN", new BigDecimal(999323.123), creditData
            );
            return ResponseEntity.ok(customerFinancialData);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping(value = "/validateCreditRequest", headers = "Accept=*/*", produces = "application/json", consumes="application/json")
    public ResponseEntity<CreditRequestValidateInfo> validateCreditRequest(@RequestBody CreditRequest creditRequest) {
        CreditRequestValidateInfo creditRequestValidateInfo = new CreditRequestValidateInfo();
        if (creditRequest.getLastPayment().doubleValue() > 100) {
            creditRequestValidateInfo.setValid(true);
            switch (creditRequest.getCurrencyType()) {
                case "USD":
                    creditRequestValidateInfo.setUpdatable(false);
                    break;
                case "PLN":
                    creditRequestValidateInfo.setUpdatable(true);
                    break;
            }
        } else {
            creditRequestValidateInfo.setValid(false);
            creditRequestValidateInfo.setUpdatable(false);
        }
        return ResponseEntity.ok(creditRequestValidateInfo);
    }

    @PostMapping(value = "/createNewContract", headers = "Accept=*/*", produces = "application/json", consumes="application/json")
    public ResponseEntity<ContractRequest> createNewContract(@RequestBody ContractRequest contractRequest) {
        return ResponseEntity.ok(contractRequest);
    }

    @PostMapping(value = "/updateContract", headers = "Accept=*/*", produces = "application/json", consumes="application/json")
    public ResponseEntity<ContractRequest> updateContract(@RequestBody ContractRequest contractRequest) {
        return ResponseEntity.ok(contractRequest);
    }
}
