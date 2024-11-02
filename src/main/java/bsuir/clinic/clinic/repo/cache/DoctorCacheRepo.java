package bsuir.clinic.clinic.repo.cache;

import bsuir.clinic.clinic.entity.cache.DoctorCache;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorCacheRepo extends CrudRepository<DoctorCache, Long> {
}
