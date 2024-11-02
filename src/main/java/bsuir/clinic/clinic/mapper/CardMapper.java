package bsuir.clinic.clinic.mapper;

import bsuir.clinic.clinic.entity.Card;
import bsuir.clinic.clinic.entity.cache.CardCache;
import bsuir.clinic.clinic.model.request.CardRequest;
import bsuir.clinic.clinic.model.response.CardResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Mapper(componentModel = "spring")
public interface CardMapper {

    @Mapping(target = "dateOfBirth", source = "cardRequest.dateOfBirth", qualifiedByName = "stringToLocalDate")
    @Mapping(target = "patient", ignore = true)
    Card toCard(CardRequest cardRequest);

    CardResponse toResponse(Card card);

    @Mapping(target = "dateOfBirth", source = "cardRequest.dateOfBirth", qualifiedByName = "stringToLocalDate")
    @Mapping(target = "patient", ignore = true)
    CardCache toCardCache(CardRequest cardRequest);

    CardResponse toResponse(CardCache card);

    // Метод для преобразования строки в LocalDate
    @Named("stringToLocalDate")
    default LocalDate stringToLocalDate(String date) {
        return date == null ? null : LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
    }

    CardCache toCache(Card object);
}
