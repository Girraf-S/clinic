package bsuir.clinic.clinic.service.cache;

import bsuir.clinic.clinic.entity.cache.CardCache;
import bsuir.clinic.clinic.exception.AppException;
import bsuir.clinic.clinic.mapper.CardMapper;
import bsuir.clinic.clinic.model.request.CardRequest;
import bsuir.clinic.clinic.model.response.CardResponse;
import bsuir.clinic.clinic.repo.cache.CardCacheRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CardCacheService {
    private final CardCacheRepo cacheRepo;
    private final CardMapper mapper;

    public CardCache save(CardRequest request) {
        return cacheRepo.save(mapper.toCardCache(request));
    }

    @Cacheable(value = "cards", key = "#id")
    public CardResponse getById(Long id) {
        return mapper.toResponse(cacheRepo.findById(id).orElseThrow(
                () -> new AppException(
                        "No such doctor with id " + id,
                        HttpStatus.BAD_REQUEST
                )
        ));
    }

    public List<CardResponse> getAll() {
        Iterable<CardCache> iterable = cacheRepo.findAll();

        iterable.forEach(mapper::toResponse);
        List<CardResponse> responseList = new ArrayList<>();
        for (CardCache cache : iterable) {
            responseList.add(mapper.toResponse(cache));
        }
        return responseList;
    }

    public void delete(Long id){
        cacheRepo.deleteById(id);
    }
}
