package bsuir.clinic.clinic.controller.v2;

import bsuir.clinic.clinic.model.request.CardRequest;
import bsuir.clinic.clinic.model.request.DoctorRequest;
import bsuir.clinic.clinic.model.response.CardResponse;
import bsuir.clinic.clinic.model.response.DoctorResponse;
import bsuir.clinic.clinic.service.cache.CardCacheService;
import bsuir.clinic.clinic.service.cache.DoctorCacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/cards")
@RequiredArgsConstructor
public class CardCacheController {

    private final CardCacheService service;

    @PostMapping
    public void save(@RequestBody CardRequest request){
        service.save(request);
    }

    @GetMapping
    public List<CardResponse> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public CardResponse get(@PathVariable Long id){
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
