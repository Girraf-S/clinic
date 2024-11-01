package bsuir.clinic.clinic.repo;

import bsuir.clinic.clinic.entity.MedicalExamination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalExaminationRepo extends JpaRepository<MedicalExamination, Long> {
}
