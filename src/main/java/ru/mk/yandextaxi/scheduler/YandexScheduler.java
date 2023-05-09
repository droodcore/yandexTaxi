package ru.mk.yandextaxi.scheduler;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.mk.yandextaxi.model.Coordinate;
import ru.mk.yandextaxi.properties.CoordinateProperties;
import ru.mk.yandextaxi.service.TaxiService;

@Service
@RequiredArgsConstructor
public class YandexScheduler {

    private final TaxiService taxiService;
    private final CoordinateProperties coordinateProperties;

    @Scheduled(fixedDelay = 30_000)
    public void updatePrice() {
        var startPoint = new Coordinate(coordinateProperties.getStartLongitude(), coordinateProperties.getStartLatitude());
        var endPoint = new Coordinate(coordinateProperties.getFinishLongitude(), coordinateProperties.getFinishLatitude());

        taxiService.getPrice(startPoint, endPoint);
    }
}
