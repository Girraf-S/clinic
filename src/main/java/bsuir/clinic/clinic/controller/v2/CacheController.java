package bsuir.clinic.clinic.controller.v2;

import bsuir.clinic.clinic.service.cache.CacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/init")
public class CacheController {

    private final CacheService cacheService;

    @PostMapping
    public void init(){
        cacheService.init();
    }
}
