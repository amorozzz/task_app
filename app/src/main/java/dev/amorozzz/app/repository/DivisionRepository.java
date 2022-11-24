package dev.amorozzz.app.repository;

import dev.amorozzz.app.model.entity.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DivisionRepository extends JpaRepository<Division,Long> {
}
