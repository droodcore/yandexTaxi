package ru.mk.yandextaxi.apiClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mk.yandextaxi.model.Price;

@FeignClient(name = "yandexClient", url = "${yandex.url}")
@Component
public interface YandexTaxiApiClient {
    @GetMapping
    Price getPrice(@RequestParam String clid, @RequestParam String apiKey, @RequestParam String rll);
}
