package bsuir.clinic.clinic.mapper;

import bsuir.clinic.clinic.entity.Doctor;
import bsuir.clinic.clinic.entity.MedicalExamination;
import bsuir.clinic.clinic.entity.MedicalHistory;
import bsuir.clinic.clinic.entity.enums.Specialization;
import bsuir.clinic.clinic.model.request.DoctorRequest;
import bsuir.clinic.clinic.model.response.DoctorResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.HashSet;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface DoctorMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "specialization", source = "doctorRequest.specialization", qualifiedByName = "stringToSpecialization")
    Doctor toDoctor(DoctorRequest doctorRequest);

    @Mapping(target = "specialization", source = "doctor.specialization", qualifiedByName = "specializationToString")
//    @Mapping(target = "medicalExaminations", source = "doctor.medicalExaminations", qualifiedByName = "medicalExaminations")
//    @Mapping(target = "medicalHistories", source = "doctor.medicalHistories", qualifiedByName = "medicalHistories")
    DoctorResponse toResponse(Doctor doctor);

    @Named("stringToSpecialization")
    default Specialization toSpecialization(String specialization) {
        return specialization == null ? null : Specialization.valueOf(specialization.toUpperCase());
    }

    @Named("specializationToString")
    default String specializationToString(Specialization specialization) {
        return specialization == null ? null : specialization.name();
    }
//    @Named("medicalExaminations")
//    default Set<MedicalExamination> getSet(Set<MedicalExamination> medicalExaminations) {
//        return medicalExaminations == null ? new HashSet<>() : medicalExaminations;
//    }
//    @Named("medicalHistories")
//    default Set<MedicalHistory> getSet2(Set<MedicalHistory> medicalHistories) {
//        return medicalHistories == null ? new HashSet<>() : medicalHistories;
//    }
}
