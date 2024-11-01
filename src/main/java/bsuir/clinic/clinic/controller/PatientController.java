package bsuir.clinic.clinic.controller;

import bsuir.clinic.clinic.entity.Patient;
import bsuir.clinic.clinic.model.request.CardRequest;
import bsuir.clinic.clinic.model.request.PatientRequest;
import bsuir.clinic.clinic.model.response.CardResponse;
import bsuir.clinic.clinic.model.response.PatientResponse;
import bsuir.clinic.clinic.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @GetMapping
    public Page<PatientResponse> getAll(Pageable pageable){
        return patientService.getAll(pageable);
    }

    @GetMapping("/{id}")
    public PatientResponse get(@PathVariable Long id){
        return patientService.getById(id);
    }

    @PostMapping
    public void create(@RequestBody PatientRequest patientRequest){
        patientService.create(patientRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        patientService.delete(id);
    }
}
