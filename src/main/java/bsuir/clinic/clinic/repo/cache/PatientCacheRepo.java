package bsuir.clinic.clinic.repo.cache;

import bsuir.clinic.clinic.entity.cache.CardCache;
import bsuir.clinic.clinic.entity.cache.PatientCache;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientCacheRepo extends CrudRepository<PatientCache, Long> {
}