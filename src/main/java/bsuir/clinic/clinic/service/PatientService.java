package bsuir.clinic.clinic.service;

import bsuir.clinic.clinic.entity.Patient;
import bsuir.clinic.clinic.exception.AppException;
import bsuir.clinic.clinic.mapper.PatientMapper;
import bsuir.clinic.clinic.model.request.PatientRequest;
import bsuir.clinic.clinic.model.response.PatientResponse;
import bsuir.clinic.clinic.repo.CardRepo;
import bsuir.clinic.clinic.repo.PatientRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepo patientRepo;
    private final CardRepo cardRepo;
    private final PatientMapper patientMapper;

    public Page<PatientResponse> getAll(Pageable pageable) {
        return patientRepo.findAll(pageable).map(patientMapper::toResponse);
    }


    public void create(PatientRequest patientRequest) {
        Patient patient = patientMapper.toPatient(patientRequest);
        patient.setCard(
                cardRepo.findById(patientRequest.getCardId())
                        .orElseThrow(() -> new AppException(
                                        "No such card with id = " + patientRequest.getCardId(),
                                        HttpStatus.BAD_REQUEST
                                )
                        )
        );
        patientRepo.save(patient);
    }

    public void delete(Long id) {
        patientRepo.deleteById(id);
    }

    public PatientResponse getById(Long id) {
        return patientMapper.toResponse(patientRepo.findById(id).orElseThrow(
                        () -> new AppException(
                                "No such card with id = " + id,
                                HttpStatus.BAD_REQUEST
                        )
                )
        );
    }
}
