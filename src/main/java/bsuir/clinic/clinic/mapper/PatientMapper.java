package bsuir.clinic.clinic.mapper;

import bsuir.clinic.clinic.entity.Patient;
import bsuir.clinic.clinic.entity.enums.Condition;
import bsuir.clinic.clinic.model.request.PatientRequest;
import bsuir.clinic.clinic.model.response.PatientResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "condition", source = "patientRequest.condition", qualifiedByName = "stringToCondition")
    @Mapping(target = "card", ignore = true)
    Patient toPatient(PatientRequest patientRequest);

    @Mapping(target = "condition", source = "patient.condition", qualifiedByName = "conditionToString")
    PatientResponse toResponse(Patient patient);

    @Named("stringToCondition")
    default Condition toCondition(String condition) {
        return condition == null ? null : Condition.valueOf(condition);
    }

    @Named("conditionToString")
    default String cToString(Condition condition) {
        return condition == null ? null : condition.name();
    }
}
