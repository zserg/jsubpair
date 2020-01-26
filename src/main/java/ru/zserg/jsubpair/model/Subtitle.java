package ru.zserg.jsubpair.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalTime;

@Getter
public class Subtitle {
    private int number;
    private LocalTime start;
    private LocalTime end;
    String text;

    public Subtitle(int number, LocalTime start, LocalTime end, String text){
        if(start.compareTo(end) >= 0){
            throw new IllegalArgumentException("'start' time is less than 'end' time");
        }
        this.number = number;
        this.start = start;
        this.end = end;
        this.text = text;
    }
}
