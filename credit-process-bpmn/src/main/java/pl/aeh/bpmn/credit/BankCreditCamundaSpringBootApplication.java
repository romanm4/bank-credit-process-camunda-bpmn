package pl.aeh.bpmn.credit;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = {"pl.aeh.bpmn.credit", "controller"})
@EnableProcessApplication("credit-process-bpmn")
public class BankCreditCamundaSpringBootApplication {

  public static void main(String... args) {
    SpringApplication.run(BankCreditCamundaSpringBootApplication.class, args);
  }

  @Bean
  public ObjectMapper getObjectMapper() {
    return new ObjectMapper();
  }

  @Bean
  public RestTemplate getRestTemplate() {
    return new RestTemplate();
  }

  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }
}
