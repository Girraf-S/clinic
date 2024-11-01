package bsuir.clinic.clinic.controller;

import bsuir.clinic.clinic.entity.Card;
import bsuir.clinic.clinic.model.request.CardRequest;
import bsuir.clinic.clinic.model.response.CardResponse;
import bsuir.clinic.clinic.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cards")
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;

    @GetMapping
    public Page<CardResponse> getAll(Pageable pageable){
        return cardService.getAll(pageable);
    }

    @GetMapping("/{id}")
    public CardResponse get(@PathVariable Long id){
        return cardService.getById(id);
    }

    @PostMapping
    public void create(@RequestBody CardRequest cardRequest){
        cardService.create(cardRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        cardService.delete(id);
    }
}
