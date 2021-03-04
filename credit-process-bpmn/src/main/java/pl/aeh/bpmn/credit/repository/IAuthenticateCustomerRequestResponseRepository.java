package pl.aeh.bpmn.credit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.aeh.bpmn.credit.entity.AuthenticateCustomerRequestResponseEntity;

@Repository
public interface IAuthenticateCustomerRequestResponseRepository extends JpaRepository<AuthenticateCustomerRequestResponseEntity, Long> {
}
