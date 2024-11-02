package bsuir.clinic.clinic.controller.v2;

import bsuir.clinic.clinic.model.request.MedicalExaminationRequest;
import bsuir.clinic.clinic.model.request.MedicalHistoryRequest;
import bsuir.clinic.clinic.model.response.MedicalExaminationResponse;
import bsuir.clinic.clinic.model.response.MedicalHistoryResponse;
import bsuir.clinic.clinic.service.cache.MedicalExaminationCacheService;
import bsuir.clinic.clinic.service.cache.MedicalHistoryCacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/medical-examinations")
@RequiredArgsConstructor
public class MedicalExaminationCacheController {

    private final MedicalExaminationCacheService service;

    @PostMapping
    public void save(@RequestBody MedicalExaminationRequest request){
        service.save(request);
    }

    @GetMapping
    public List<MedicalExaminationResponse> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public MedicalExaminationResponse get(@PathVariable Long id){
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
