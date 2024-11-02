package bsuir.clinic.clinic.repo.cache;

import bsuir.clinic.clinic.entity.cache.CardCache;
import bsuir.clinic.clinic.entity.cache.TreatmentCache;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreatmentCacheRepo extends CrudRepository<TreatmentCache, Long> {
}