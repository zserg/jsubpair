package ru.zserg.jsubpair.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalTime;

@Getter
@AllArgsConstructor
public class Subtitle {
    private int number;
    private LocalTime start;
    private LocalTime end;
    String text;
}
