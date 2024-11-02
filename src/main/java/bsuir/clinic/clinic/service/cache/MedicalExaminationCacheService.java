package bsuir.clinic.clinic.service.cache;

import bsuir.clinic.clinic.entity.MedicalExamination;
import bsuir.clinic.clinic.entity.cache.CardCache;
import bsuir.clinic.clinic.entity.cache.MedicalExaminationCache;
import bsuir.clinic.clinic.exception.AppException;
import bsuir.clinic.clinic.mapper.CardMapper;
import bsuir.clinic.clinic.mapper.MedicalExaminationMapper;
import bsuir.clinic.clinic.model.request.CardRequest;
import bsuir.clinic.clinic.model.request.MedicalExaminationRequest;
import bsuir.clinic.clinic.model.response.CardResponse;
import bsuir.clinic.clinic.model.response.MedicalExaminationResponse;
import bsuir.clinic.clinic.repo.cache.*;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicalExaminationCacheService {
    private final MedicalExaminationCacheRepo cacheRepo;
    private final PatientCacheRepo patientCacheRepo;
    private final DoctorCacheRepo doctorCacheRepo;
    private final TreatmentCacheRepo treatmentCacheRepo;
    private final MedicalExaminationMapper mapper;

    public MedicalExaminationCache save(MedicalExaminationRequest request) {
        MedicalExaminationCache medicalExamination = mapper.toMedicalExaminationCache(request);
        medicalExamination.setPatient(
                patientCacheRepo.findById(request.getPatientId()).orElseThrow(
                        () -> new AppException(
                                "No such patient with id " + request.getPatientId(),
                                HttpStatus.BAD_REQUEST
                        )
                )
        );
        medicalExamination.setDoctor(
                doctorCacheRepo.findById(request.getDoctorId()).orElseThrow(
                        () -> new AppException(
                                "No such doctor with id " + request.getDoctorId(),
                                HttpStatus.BAD_REQUEST
                        )
                )
        );

        return cacheRepo.save(medicalExamination);
    }

    @Cacheable(value = "medicalExaminations", key = "#id")
    public MedicalExaminationResponse getById(Long id) {
        return mapper.toResponse(cacheRepo.findById(id).orElseThrow(
                () -> new AppException(
                        "No such doctor with id " + id,
                        HttpStatus.BAD_REQUEST
                )
        ));
    }

    public List<MedicalExaminationResponse> getAll() {
        Iterable<MedicalExaminationCache> iterable = cacheRepo.findAll();

        iterable.forEach(mapper::toResponse);
        List<MedicalExaminationResponse> responseList = new ArrayList<>();
        for (MedicalExaminationCache cache : iterable) {
            responseList.add(mapper.toResponse(cache));
        }
        return responseList;
    }

    public void delete(Long id) {
        cacheRepo.deleteById(id);
    }
}
