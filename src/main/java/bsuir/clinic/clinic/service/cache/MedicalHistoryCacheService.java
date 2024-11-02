package bsuir.clinic.clinic.service.cache;

import bsuir.clinic.clinic.entity.cache.CardCache;
import bsuir.clinic.clinic.entity.cache.MedicalHistoryCache;
import bsuir.clinic.clinic.exception.AppException;
import bsuir.clinic.clinic.mapper.CardMapper;
import bsuir.clinic.clinic.mapper.MedicalHistoryMapper;
import bsuir.clinic.clinic.model.request.CardRequest;
import bsuir.clinic.clinic.model.request.MedicalHistoryRequest;
import bsuir.clinic.clinic.model.response.CardResponse;
import bsuir.clinic.clinic.model.response.MedicalHistoryResponse;
import bsuir.clinic.clinic.repo.cache.CardCacheRepo;
import bsuir.clinic.clinic.repo.cache.DoctorCacheRepo;
import bsuir.clinic.clinic.repo.cache.MedicalHistoryCacheRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicalHistoryCacheService {
    private final MedicalHistoryCacheRepo cacheRepo;
    private final CardCacheRepo cardCacheRepo;
    private final DoctorCacheRepo doctorCacheRepo;
    private final MedicalHistoryMapper mapper;

    public MedicalHistoryCache save(MedicalHistoryRequest request) {
        MedicalHistoryCache medicalHistoryCache = mapper.toMedicalHistoryCache(request);
        medicalHistoryCache.setCard(
                cardCacheRepo.findById(request.getCardId()).orElseThrow(
                        () -> new AppException(
                                "No such card with id " + request.getCardId(),
                                HttpStatus.BAD_REQUEST
                        )
                ));
        medicalHistoryCache.setDoctor(
                doctorCacheRepo.findById(request.getCardId()).orElseThrow(
                        () -> new AppException(
                                "No such doctor with id " + request.getDoctorId(),
                                HttpStatus.BAD_REQUEST
                        )
                ));

        return cacheRepo.save(medicalHistoryCache);
    }

    @Cacheable(value = "medicalHistories", key = "#id")
    public MedicalHistoryResponse getById(Long id) {
        return mapper.toResponse(cacheRepo.findById(id).orElseThrow(
                () -> new AppException(
                        "No such doctor with id " + id,
                        HttpStatus.BAD_REQUEST
                )
        ));
    }

    public List<MedicalHistoryResponse> getAll() {
        Iterable<MedicalHistoryCache> iterable = cacheRepo.findAll();

        iterable.forEach(mapper::toResponse);
        List<MedicalHistoryResponse> responseList = new ArrayList<>();
        for (MedicalHistoryCache cache : iterable) {
            responseList.add(mapper.toResponse(cache));
        }
        return responseList;
    }

    public void delete(Long id) {
        cacheRepo.deleteById(id);
    }
}
