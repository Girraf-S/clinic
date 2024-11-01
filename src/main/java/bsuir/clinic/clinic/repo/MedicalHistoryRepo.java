package bsuir.clinic.clinic.repo;

import bsuir.clinic.clinic.entity.MedicalHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalHistoryRepo extends JpaRepository<MedicalHistory, Long> {
}
