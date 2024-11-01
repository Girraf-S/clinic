package bsuir.clinic.clinic.mapper;

import bsuir.clinic.clinic.entity.MedicalExamination;
import bsuir.clinic.clinic.model.request.MedicalExaminationRequest;
import bsuir.clinic.clinic.model.response.MedicalExaminationResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring")
public interface MedicalExaminationMapper {

    @Mapping(target = "patient", ignore = true)
    @Mapping(target = "doctor", ignore = true)
    @Mapping(target = "treatment", ignore = true)
    MedicalExamination toMedicalExamination(MedicalExaminationRequest medicalExaminationRequest);

    MedicalExaminationResponse toResponse(MedicalExamination medicalExamination);

    @Named("getCurrentDateTime")
    default LocalDateTime getCurrentDateTime(){
        return LocalDateTime.now();
    }
}
