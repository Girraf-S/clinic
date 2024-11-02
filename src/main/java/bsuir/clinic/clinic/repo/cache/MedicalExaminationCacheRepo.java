package bsuir.clinic.clinic.repo.cache;

import bsuir.clinic.clinic.entity.cache.MedicalExaminationCache;
import bsuir.clinic.clinic.entity.cache.MedicalHistoryCache;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalExaminationCacheRepo extends CrudRepository<MedicalExaminationCache, Long> {
}