package bsuir.clinic.clinic.repo;

import bsuir.clinic.clinic.entity.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreatmentRepo extends JpaRepository<Treatment, Long> {
}
