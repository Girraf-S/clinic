package bsuir.clinic.clinic.service.cache;

import bsuir.clinic.clinic.entity.Doctor;
import bsuir.clinic.clinic.entity.cache.CardCache;
import bsuir.clinic.clinic.entity.cache.MedicalHistoryCache;
import bsuir.clinic.clinic.entity.cache.TreatmentCache;
import bsuir.clinic.clinic.exception.AppException;
import bsuir.clinic.clinic.mapper.CardMapper;
import bsuir.clinic.clinic.mapper.TreatmentMapper;
import bsuir.clinic.clinic.model.request.CardRequest;
import bsuir.clinic.clinic.model.request.TreatmentRequest;
import bsuir.clinic.clinic.model.response.CardResponse;
import bsuir.clinic.clinic.model.response.TreatmentResponse;
import bsuir.clinic.clinic.repo.cache.CardCacheRepo;
import bsuir.clinic.clinic.repo.cache.DoctorCacheRepo;
import bsuir.clinic.clinic.repo.cache.MedicalHistoryCacheRepo;
import bsuir.clinic.clinic.repo.cache.TreatmentCacheRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TreatmentCacheService {
    private final TreatmentCacheRepo cacheRepo;
    private final DoctorCacheRepo doctorCacheRepo;
    private final MedicalHistoryCacheRepo medicalHistoryCacheRepo;
    private final TreatmentMapper mapper;

    public TreatmentCache save(TreatmentRequest request) {
        TreatmentCache treatmentCache = mapper.toTreatmentCache(request);
        treatmentCache.setDoctor(
                doctorCacheRepo.findById(request.getDoctorId())
                        .orElseThrow(()-> new AppException(
                                "No doctor with id = "+ request.getDoctorId(),
                                HttpStatus.BAD_REQUEST
                        ))
        );
        treatmentCache.setMedicalHistory(
               medicalHistoryCacheRepo.findById(request.getDoctorId())
                       .orElseThrow(()-> new AppException(
                               "No medical history with id = "+ request.getMedicalHistoryId(),
                               HttpStatus.BAD_REQUEST
                       ))
        );
        return cacheRepo.save(treatmentCache);
    }

    @Cacheable(value = "treatments", key = "#id")
    public TreatmentResponse getById(Long id) {
        return mapper.toResponse(cacheRepo.findById(id).orElseThrow(
                () -> new AppException(
                        "No such doctor with id " + id,
                        HttpStatus.BAD_REQUEST
                )
        ));
    }

    public List<TreatmentResponse> getAll() {
        Iterable<TreatmentCache> iterable = cacheRepo.findAll();

        iterable.forEach(mapper::toResponse);
        List<TreatmentResponse> responseList = new ArrayList<>();
        for (TreatmentCache cache : iterable) {
            responseList.add(mapper.toResponse(cache));
        }
        return responseList;
    }

    public void delete(Long id){
        cacheRepo.deleteById(id);
    }
}
