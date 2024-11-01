package bsuir.clinic.clinic.controller;

import bsuir.clinic.clinic.model.request.CardRequest;
import bsuir.clinic.clinic.model.request.MedicalHistoryRequest;
import bsuir.clinic.clinic.model.response.CardResponse;
import bsuir.clinic.clinic.model.response.MedicalHistoryResponse;
import bsuir.clinic.clinic.service.MedicalHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/medical-histories")
@RequiredArgsConstructor
public class MedicalHistoryController {
    private final MedicalHistoryService medicalHistoryService;

    @GetMapping
    public Page<MedicalHistoryResponse> getAll(Pageable pageable){
        return medicalHistoryService.getAll(pageable);
    }

    @GetMapping("/{id}")
    public MedicalHistoryResponse get(@PathVariable Long id){
        return medicalHistoryService.getById(id);
    }

    @PostMapping
    public void create(@RequestBody MedicalHistoryRequest medicalHistoryRequest){
        medicalHistoryService.create(medicalHistoryRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        medicalHistoryService.delete(id);
    }
}
