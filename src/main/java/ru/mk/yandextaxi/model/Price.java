package ru.mk.yandextaxi.model;

import lombok.Data;

import java.util.List;

@Data
public class Price {
    private List<Option> options;
    private String currency;
    private Double distance;
    private String time_text;
}
