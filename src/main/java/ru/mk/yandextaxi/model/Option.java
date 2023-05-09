package ru.mk.yandextaxi.model;

import lombok.Data;

@Data
public class Option {
    private Double price;
    private Double min_price;
    private Double waiting_time;
    private String class_name;
    private String price_text;

}
