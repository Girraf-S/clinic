package bsuir.clinic.clinic.controller.v2;

import bsuir.clinic.clinic.model.request.DoctorRequest;
import bsuir.clinic.clinic.model.response.DoctorResponse;
import bsuir.clinic.clinic.service.cache.DoctorCacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/doctors")
@RequiredArgsConstructor
public class DoctorCacheController {

    private final DoctorCacheService service;

    @PostMapping
    public void save(@RequestBody DoctorRequest doctorRequest){
        service.save(doctorRequest);
    }

    @GetMapping
    public List<DoctorResponse> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public DoctorResponse get(@PathVariable Long id){
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
