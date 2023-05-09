package ru.mk.yandextaxi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.mk.yandextaxi.apiClient.YandexTaxiApiClient;
import ru.mk.yandextaxi.model.Coordinate;
import ru.mk.yandextaxi.model.MomentPrice;
import ru.mk.yandextaxi.model.Price;
import ru.mk.yandextaxi.properties.YandexProperties;
import ru.mk.yandextaxi.repository.PriceRepository;

import java.time.LocalDateTime;
import java.time.ZoneId;

@RequiredArgsConstructor
@Service
public class TaxiService {

    private final YandexProperties yandexProperties;
    private final YandexTaxiApiClient yandexTaxiApiClient;
    private final PriceRepository priceRepository;

    public void getPrice(Coordinate startPoint, Coordinate endPoint) {
        var rll = startPoint + "~" + endPoint;
        var clid = yandexProperties.getClid();
        var apiKey = yandexProperties.getApiKey();

        Price currentPrice = yandexTaxiApiClient.getPrice(clid, apiKey, rll);

        if(currentPrice.getOptions().isEmpty()) throw new RuntimeException("Options are empty");

        var priceDouble = currentPrice.getOptions().get(0).getPrice();

        MomentPrice momentPrice = new MomentPrice(
                LocalDateTime.now(ZoneId.of("Asia/Yekaterinburg")),
                priceDouble
        );

        priceRepository.save(momentPrice);
    }
}
