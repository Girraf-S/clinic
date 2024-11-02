package bsuir.clinic.clinic.mapper;

import bsuir.clinic.clinic.entity.Doctor;
import bsuir.clinic.clinic.entity.MedicalExamination;
import bsuir.clinic.clinic.entity.MedicalHistory;
import bsuir.clinic.clinic.entity.cache.DoctorCache;
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
    DoctorResponse toResponse(Doctor doctor);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "specialization", source = "doctorRequest.specialization", qualifiedByName = "stringToSpecialization")
    DoctorCache toDoctorCache(DoctorRequest doctorRequest);


    @Mapping(target = "specialization", source = "doctorCache.specialization", qualifiedByName = "specializationToString")
    DoctorResponse toResponse(DoctorCache doctorCache);


    DoctorCache toCache(Doctor doctor);

    @Named("stringToSpecialization")
    default Specialization toSpecialization(String specialization) {
        return specialization == null ? null : Specialization.valueOf(specialization.toUpperCase());
    }

    @Named("specializationToString")
    default String specializationToString(Specialization specialization) {
        return specialization == null ? null : specialization.name();
    }

}
