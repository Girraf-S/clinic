package bsuir.clinic.clinic.controller.v2;

import bsuir.clinic.clinic.model.request.CardRequest;
import bsuir.clinic.clinic.model.request.TreatmentRequest;
import bsuir.clinic.clinic.model.response.CardResponse;
import bsuir.clinic.clinic.model.response.TreatmentResponse;
import bsuir.clinic.clinic.service.cache.CardCacheService;
import bsuir.clinic.clinic.service.cache.TreatmentCacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/treatments")
@RequiredArgsConstructor
public class TreatmentCacheController {

    private final TreatmentCacheService service;

    @PostMapping
    public void save(@RequestBody TreatmentRequest request){
        service.save(request);
    }

    @GetMapping
    public List<TreatmentResponse> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public TreatmentResponse get(@PathVariable Long id){
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
