package bsuir.clinic.clinic.service.cache;

import bsuir.clinic.clinic.entity.cache.CardCache;
import bsuir.clinic.clinic.entity.cache.PatientCache;
import bsuir.clinic.clinic.exception.AppException;
import bsuir.clinic.clinic.mapper.CardMapper;
import bsuir.clinic.clinic.mapper.PatientMapper;
import bsuir.clinic.clinic.model.request.CardRequest;
import bsuir.clinic.clinic.model.request.PatientRequest;
import bsuir.clinic.clinic.model.response.CardResponse;
import bsuir.clinic.clinic.model.response.PatientResponse;
import bsuir.clinic.clinic.repo.cache.CardCacheRepo;
import bsuir.clinic.clinic.repo.cache.PatientCacheRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientCacheService {
    private final PatientCacheRepo cacheRepo;
    private final CardCacheRepo cardCacheRepo;
    private final PatientMapper mapper;

    public PatientCache save(PatientRequest request) {
        PatientCache patientCache = mapper.toPatientCache(request);
        patientCache.setCard(
                cardCacheRepo.findById(
                        request.getCardId()
                )
                        .orElseThrow(()-> new AppException(
                                "No card with id = "+ request.getCardId(),
                                HttpStatus.BAD_REQUEST
                        ))
        );
        return cacheRepo.save(patientCache);
    }

    @Cacheable(value = "patients", key = "#id")
    public PatientResponse getById(Long id) {
        return mapper.toResponse(cacheRepo.findById(id).orElseThrow(
                () -> new AppException(
                        "No such doctor with id " + id,
                        HttpStatus.BAD_REQUEST
                )
        ));
    }

    public List<PatientResponse> getAll() {
        Iterable<PatientCache> iterable = cacheRepo.findAll();

        iterable.forEach(mapper::toResponse);
        List<PatientResponse> responseList = new ArrayList<>();
        for (PatientCache cache : iterable) {
            responseList.add(mapper.toResponse(cache));
        }
        return responseList;
    }

    public void delete(Long id){
        cacheRepo.deleteById(id);
    }
}
