package bsuir.clinic.clinic.service;

import bsuir.clinic.clinic.entity.MedicalHistory;
import bsuir.clinic.clinic.exception.AppException;
import bsuir.clinic.clinic.mapper.MedicalHistoryMapper;
import bsuir.clinic.clinic.model.request.MedicalHistoryRequest;
import bsuir.clinic.clinic.model.response.MedicalHistoryResponse;
import bsuir.clinic.clinic.repo.CardRepo;
import bsuir.clinic.clinic.repo.DoctorRepo;
import bsuir.clinic.clinic.repo.MedicalHistoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MedicalHistoryService {

    private final MedicalHistoryRepo medicalHistoryRepo;
    private final MedicalHistoryMapper medicalHistoryMapper;
    private final CardRepo cardRepo;
    private final DoctorRepo doctorRepo;

    public Page<MedicalHistoryResponse> getAll(Pageable pageable) {
        return medicalHistoryRepo.findAll(pageable).map(medicalHistoryMapper::toResponse);
    }

    public MedicalHistoryResponse getById(Long id) {
        return medicalHistoryMapper.toResponse(medicalHistoryRepo.findById(id).
                orElseThrow(
                        () -> new AppException("No such history with id = " + id,
                                HttpStatus.BAD_REQUEST)
                )
        );
    }

    public void create(MedicalHistoryRequest medicalHistoryRequest) {
        MedicalHistory medicalHistory = medicalHistoryMapper.toMedicalHistory(medicalHistoryRequest);
        medicalHistory.setCard(
                cardRepo.findById(medicalHistoryRequest.getCardId()).orElseThrow(
                        () -> new AppException("No such card with id = " + medicalHistoryRequest.getCardId(),
                                HttpStatus.BAD_REQUEST)
                )
        );
        medicalHistory.setDoctor(
                doctorRepo.findById(medicalHistoryRequest.getDoctorId()).orElseThrow(
                        () -> new AppException("No such doctor with id = " + medicalHistoryRequest.getDoctorId(),
                                HttpStatus.BAD_REQUEST)
                )
        );

        medicalHistory.setStartTreatment(LocalDate.now());

        medicalHistoryRepo.save(medicalHistory);
    }

    public void delete(Long id) {
        medicalHistoryRepo.deleteById(id);
    }
}
