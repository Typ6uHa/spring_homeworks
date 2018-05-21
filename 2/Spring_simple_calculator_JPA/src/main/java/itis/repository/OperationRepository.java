package itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import itis.model.Calculator;

public interface OperationRepository extends JpaRepository<Calculator,Long> {
}
