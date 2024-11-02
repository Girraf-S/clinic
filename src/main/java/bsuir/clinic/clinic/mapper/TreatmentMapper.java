package bsuir.clinic.clinic.mapper;

import bsuir.clinic.clinic.entity.Treatment;
import bsuir.clinic.clinic.entity.cache.TreatmentCache;
import bsuir.clinic.clinic.model.request.TreatmentRequest;
import bsuir.clinic.clinic.model.response.TreatmentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TreatmentMapper {

    @Mapping(target = "doctor", ignore = true)
    @Mapping(target = "medicalHistory", ignore = true)
    @Mapping(target = "medicalExamination", ignore = true)
    Treatment toTreatment(TreatmentRequest treatmentRequest);

    TreatmentResponse toResponse(Treatment treatment);

    @Mapping(target = "doctor", ignore = true)
    @Mapping(target = "medicalHistory", ignore = true)
    @Mapping(target = "medicalExamination", ignore = true)
    TreatmentCache toTreatmentCache(TreatmentRequest treatmentRequest);

    TreatmentResponse toResponse(TreatmentCache treatment);

    TreatmentCache toCache(Treatment object);
}
