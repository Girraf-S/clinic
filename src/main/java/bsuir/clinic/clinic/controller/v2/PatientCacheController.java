package bsuir.clinic.clinic.controller.v2;

import bsuir.clinic.clinic.model.request.CardRequest;
import bsuir.clinic.clinic.model.request.PatientRequest;
import bsuir.clinic.clinic.model.response.CardResponse;
import bsuir.clinic.clinic.model.response.PatientResponse;
import bsuir.clinic.clinic.service.cache.CardCacheService;
import bsuir.clinic.clinic.service.cache.PatientCacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/patients")
@RequiredArgsConstructor
public class PatientCacheController {

    private final PatientCacheService service;

    @PostMapping
    public void save(@RequestBody PatientRequest request){
        service.save(request);
    }

    @GetMapping
    public List<PatientResponse> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public PatientResponse get(@PathVariable Long id){
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
