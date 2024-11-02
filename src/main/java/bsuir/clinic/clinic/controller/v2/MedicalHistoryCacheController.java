package bsuir.clinic.clinic.controller.v2;

import bsuir.clinic.clinic.model.request.CardRequest;
import bsuir.clinic.clinic.model.request.MedicalHistoryRequest;
import bsuir.clinic.clinic.model.response.CardResponse;
import bsuir.clinic.clinic.model.response.MedicalHistoryResponse;
import bsuir.clinic.clinic.service.cache.CardCacheService;
import bsuir.clinic.clinic.service.cache.MedicalHistoryCacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/medical-histories")
@RequiredArgsConstructor
public class MedicalHistoryCacheController {

    private final MedicalHistoryCacheService service;

    @PostMapping
    public void save(@RequestBody MedicalHistoryRequest request){
        service.save(request);
    }

    @GetMapping
    public List<MedicalHistoryResponse> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public MedicalHistoryResponse get(@PathVariable Long id){
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
