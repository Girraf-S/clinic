package bsuir.clinic.clinic.controller;

import bsuir.clinic.clinic.model.request.CardRequest;
import bsuir.clinic.clinic.model.request.MedicalExaminationRequest;
import bsuir.clinic.clinic.model.response.CardResponse;
import bsuir.clinic.clinic.model.response.MedicalExaminationResponse;
import bsuir.clinic.clinic.service.MedicalExaminationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/medical-examinations")
@RequiredArgsConstructor
public class MedicalExaminationController {

    private final MedicalExaminationService medicalExaminationService;

    @GetMapping
    public Page<MedicalExaminationResponse> getAll(Pageable pageable){
        return medicalExaminationService.getAll(pageable);
    }

    @GetMapping("/{id}")
    public MedicalExaminationResponse get(@PathVariable Long id){
        return medicalExaminationService.getById(id);
    }

    @PostMapping
    public void create(@RequestBody MedicalExaminationRequest medicalExaminationRequest){
        medicalExaminationService.create(medicalExaminationRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        medicalExaminationService.delete(id);
    }
}
