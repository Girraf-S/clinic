package bsuir.clinic.clinic.controller;

import bsuir.clinic.clinic.model.request.DoctorRequest;
import bsuir.clinic.clinic.model.response.DoctorResponse;
import bsuir.clinic.clinic.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/doctors")
@RequiredArgsConstructor
public class DoctorController {
    private final DoctorService doctorService;

    @GetMapping
    public Page<DoctorResponse> getAll(Pageable pageable){
        return doctorService.getAll(pageable);
    }

    @GetMapping("/{id}")
    public DoctorResponse get(@PathVariable Long id){
        return doctorService.getById(id);
    }

    @PostMapping
    public void create(@RequestBody DoctorRequest doctorRequest){
        doctorService.create(doctorRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        doctorService.delete(id);
    }
}
