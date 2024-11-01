package bsuir.clinic.clinic.controller;

import bsuir.clinic.clinic.model.request.CardRequest;
import bsuir.clinic.clinic.model.request.TreatmentRequest;
import bsuir.clinic.clinic.model.response.CardResponse;
import bsuir.clinic.clinic.model.response.TreatmentResponse;
import bsuir.clinic.clinic.service.TreatmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/treatments")
@RequiredArgsConstructor
public class TreatmentController {
    private final TreatmentService treatmentService;

    @GetMapping
    public Page<TreatmentResponse> getAll(Pageable pageable){
        return treatmentService.getAll(pageable);
    }

    @GetMapping("/{id}")
    public TreatmentResponse get(@PathVariable Long id){
        return treatmentService.getById(id);
    }

    @PostMapping
    public void create(@RequestBody TreatmentRequest treatmentRequest){
        treatmentService.create(treatmentRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        treatmentService.delete(id);
    }
}
