package pl.aeh.bpmn.credit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.aeh.bpmn.credit.entity.BankCreditResponseEntity;

@Repository
public interface IBankCreditResponseRepository extends JpaRepository<BankCreditResponseEntity, Long> {
}
