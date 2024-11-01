package bsuir.clinic.clinic.service;

import bsuir.clinic.clinic.entity.MedicalExamination;
import bsuir.clinic.clinic.exception.AppException;
import bsuir.clinic.clinic.mapper.MedicalExaminationMapper;
import bsuir.clinic.clinic.model.request.MedicalExaminationRequest;
import bsuir.clinic.clinic.model.response.MedicalExaminationResponse;
import bsuir.clinic.clinic.repo.DoctorRepo;
import bsuir.clinic.clinic.repo.MedicalExaminationRepo;
import bsuir.clinic.clinic.repo.PatientRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MedicalExaminationService {

    private final MedicalExaminationMapper medicalExaminationMapper;
    private final MedicalExaminationRepo medicalExaminationRepo;
    private final DoctorRepo doctorRepo;
    private final PatientRepo patientRepo;


    public Page<MedicalExaminationResponse> getAll(Pageable pageable) {
        return medicalExaminationRepo.findAll(pageable).map(medicalExaminationMapper::toResponse);
    }

    public MedicalExaminationResponse getById(Long id) {
        return medicalExaminationMapper.toResponse(
                medicalExaminationRepo.findById(id)
                        .orElseThrow(() -> new AppException(
                                        "No such medical examination with id = " + id,
                                        HttpStatus.BAD_REQUEST
                                )
                        )
        );
    }

    public void create(MedicalExaminationRequest request) {
        MedicalExamination medicalExamination = medicalExaminationMapper.toMedicalExamination(request);
        medicalExamination.setDoctor(
                doctorRepo.findById(request.getDoctorId())
                        .orElseThrow(() -> new AppException(
                                "No such medical examination with id = " + request.getDoctorId(),
                                HttpStatus.BAD_REQUEST
                        ))
        );
        medicalExamination.setPatient(
                patientRepo.findById(request.getDoctorId())
                        .orElseThrow(() -> new AppException(
                                "No such medical examination with id = " + request.getPatientId(),
                                HttpStatus.BAD_REQUEST
                        ))
        );

        medicalExamination.setDateTime(LocalDateTime.now());
        medicalExaminationRepo.save(medicalExamination);
    }

    public void delete(Long id) {
        medicalExaminationRepo.deleteById(id);
    }
}
