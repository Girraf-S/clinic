package bsuir.clinic.clinic.mapper;

import bsuir.clinic.clinic.entity.MedicalHistory;
import bsuir.clinic.clinic.entity.cache.MedicalHistoryCache;
import bsuir.clinic.clinic.model.request.MedicalHistoryRequest;
import bsuir.clinic.clinic.model.response.MedicalHistoryResponse;
import jdk.jfr.Name;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring")
public interface MedicalHistoryMapper {

    @Mapping(target = "card", ignore = true)
    @Mapping(target = "doctor", ignore = true)
    MedicalHistory toMedicalHistory(MedicalHistoryRequest medicalExaminationRequest);

    MedicalHistoryResponse toResponse(MedicalHistory medicalHistory);

    @Mapping(target = "card", ignore = true)
    @Mapping(target = "doctor", ignore = true)
    MedicalHistoryCache toMedicalHistoryCache(MedicalHistoryRequest medicalExaminationRequest);

    MedicalHistoryResponse toResponse(MedicalHistoryCache medicalHistory);

    MedicalHistoryCache toCache(MedicalHistory object);
}
