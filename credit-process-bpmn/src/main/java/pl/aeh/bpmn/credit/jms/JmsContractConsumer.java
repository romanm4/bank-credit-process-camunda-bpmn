package pl.aeh.bpmn.credit.jms;

import org.apache.log4j.Logger;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import pl.aeh.bpmn.credit.dto.ContractRequestDTO;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

@Component
public class JmsContractConsumer implements MessageListener {

    private static final Logger logger = Logger.getLogger(JmsContractConsumer.class);

    @Override
    @JmsListener(destination = "${queue.contract}")
    public void onMessage(Message message) {
        try {
            ObjectMessage objectMessage = (ObjectMessage) message;
            ContractRequestDTO contractRequestDTO = (ContractRequestDTO) objectMessage.getObject();
            logger.info("Received Message: " + contractRequestDTO.toString());
        } catch(Exception e) {
            logger.error("Received Exception : " + e);
        }
    }
}
