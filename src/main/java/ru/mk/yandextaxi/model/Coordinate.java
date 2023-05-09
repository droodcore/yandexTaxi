package ru.mk.yandextaxi.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Coordinate {
    private String longitude;
    private String latitude;

    @Override
    public String toString() {
        return longitude + "," + latitude;
    }
}
