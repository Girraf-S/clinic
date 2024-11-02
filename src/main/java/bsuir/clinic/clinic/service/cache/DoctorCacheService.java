package bsuir.clinic.clinic.service.cache;

import bsuir.clinic.clinic.entity.cache.DoctorCache;
import bsuir.clinic.clinic.exception.AppException;
import bsuir.clinic.clinic.mapper.DoctorMapper;
import bsuir.clinic.clinic.model.request.DoctorRequest;
import bsuir.clinic.clinic.model.response.DoctorResponse;
import bsuir.clinic.clinic.repo.cache.DoctorCacheRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorCacheService {

    private final DoctorCacheRepo doctorCacheRepo;
    private final DoctorMapper doctorMapper;

    public DoctorCache save(DoctorRequest doctor) {
        return doctorCacheRepo.save(doctorMapper.toDoctorCache(doctor));
    }

    @Cacheable(value = "doctors", key = "#id")
    public DoctorResponse getById(Long id) {
        return doctorMapper.toResponse(doctorCacheRepo.findById(id).orElseThrow(
                () -> new AppException(
                        "No such doctor with id " + id,
                        HttpStatus.BAD_REQUEST
                )
        ));
    }

    public List<DoctorResponse> getAll() {
        Iterable<DoctorCache> doctors = doctorCacheRepo.findAll();

        doctors.forEach(doctorMapper::toResponse);
        List<DoctorResponse> doctorResponseList = new ArrayList<>();
        for (DoctorCache doctorCache : doctors) {
            doctorResponseList.add(doctorMapper.toResponse(doctorCache));
        }
        return doctorResponseList;
    }

    public void delete(Long id){
        doctorCacheRepo.deleteById(id);
    }
}
