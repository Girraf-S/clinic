package bsuir.clinic.clinic.service;

import bsuir.clinic.clinic.exception.AppException;
import bsuir.clinic.clinic.mapper.CardMapper;
import bsuir.clinic.clinic.model.request.CardRequest;
import bsuir.clinic.clinic.model.response.CardResponse;
import bsuir.clinic.clinic.repo.CardRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepo cardRepo;
    private final CardMapper cardMapper;

    public Page<CardResponse> getAll(Pageable pageable) {
        return cardRepo.findAll(pageable).map(cardMapper::toResponse);
    }

    public CardResponse getById(Long id) {
        return cardMapper.toResponse(
                cardRepo.findById(id)
                        .orElseThrow(()-> new AppException("No such user with id "+ id, HttpStatus.BAD_REQUEST))
        );
    }

    public void create(CardRequest cardRequest) {
        cardRepo.save(cardMapper.toCard(cardRequest));
    }

    public void delete(Long id) {
        cardRepo.deleteById(id);
    }
}
