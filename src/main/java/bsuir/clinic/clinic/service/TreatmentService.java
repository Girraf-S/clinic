package bsuir.clinic.clinic.service;

import bsuir.clinic.clinic.entity.MedicalExamination;
import bsuir.clinic.clinic.entity.Treatment;
import bsuir.clinic.clinic.exception.AppException;
import bsuir.clinic.clinic.mapper.TreatmentMapper;
import bsuir.clinic.clinic.model.request.TreatmentRequest;
import bsuir.clinic.clinic.model.response.TreatmentResponse;
import bsuir.clinic.clinic.repo.DoctorRepo;
import bsuir.clinic.clinic.repo.MedicalExaminationRepo;
import bsuir.clinic.clinic.repo.MedicalHistoryRepo;
import bsuir.clinic.clinic.repo.TreatmentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TreatmentService {

    private final TreatmentRepo treatmentRepo;
    private final DoctorRepo doctorRepo;
    private final MedicalHistoryRepo medicalHistoryRepo;
    private final TreatmentMapper treatmentMapper;
    private final MedicalExaminationRepo medicalExaminationRepo;

    public Page<TreatmentResponse> getAll(Pageable pageable) {
        return treatmentRepo.findAll(pageable).map(treatmentMapper::toResponse);
    }

    public TreatmentResponse getById(Long id) {
        return treatmentMapper.toResponse(
                treatmentRepo.findById(id)
                        .orElseThrow(
                                () -> new AppException("No such treatment with id = " + id,
                                        HttpStatus.BAD_REQUEST)
                        )
        );
    }

    public void create(TreatmentRequest treatmentRequest) {
        Treatment treatment = treatmentMapper.toTreatment(treatmentRequest);
        treatment.setDoctor(
                doctorRepo.findById(treatmentRequest.getDoctorId())
                        .orElseThrow(
                                () -> new AppException("No such Doctor with id = " + treatmentRequest.getDoctorId(),
                                        HttpStatus.BAD_REQUEST)
                        )
        );

        treatment.setMedicalHistory(
                medicalHistoryRepo.findById(treatmentRequest.getMedicalHistoryId())
                        .orElseThrow(
                                () -> new AppException(
                                        "No such history with id = " + treatmentRequest.getMedicalHistoryId(),
                                        HttpStatus.BAD_REQUEST)
                        )
        );

        treatment.setMedicalExamination(
                medicalExaminationRepo.findById(treatmentRequest.getMedicalExaminationId())
                        .orElseThrow(
                                () -> new AppException(
                                        "No such examination with id = " + treatmentRequest.getMedicalExaminationId(),
                                        HttpStatus.BAD_REQUEST)
                        )
        );

        treatmentRepo.save(treatment);
    }

    public void delete(Long id) {
        treatmentRepo.deleteById(id);
    }
}
