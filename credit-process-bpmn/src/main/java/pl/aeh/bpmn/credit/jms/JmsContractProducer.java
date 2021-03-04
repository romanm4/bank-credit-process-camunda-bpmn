package pl.aeh.bpmn.credit.jms;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import pl.aeh.bpmn.credit.dto.ContractRequestDTO;

@Component
public class JmsContractProducer {

    private static final Logger logger = Logger.getLogger(JmsContractProducer.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    @Value("${queue.contract}")
    private String queue;

    public void sendContractToQueue(ContractRequestDTO message) {
        try{
            logger.info("Attempting Send message to Topic: " + queue);
            jmsTemplate.convertAndSend(queue, message);
        } catch(Exception e){
            logger.error("Recieved Exception during send Message: ", e);
        }
    }
}
