package ru.zserg.jsubpair.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Sub {
    private String title;
    private String language;
    private String imdb;
    private String year;
    private List<Subtitle> subs;
}
