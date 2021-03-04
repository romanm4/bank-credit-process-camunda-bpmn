package pl.aeh.bpmn.credit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.aeh.bpmn.credit.entity.CustomerFinancialDataRequestResponseEntity;

@Repository
public interface ICustomerFinancialDataRequestResponseRepository extends JpaRepository<CustomerFinancialDataRequestResponseEntity, Long> {
}
