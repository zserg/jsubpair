package ru.zserg.jsubpair;

import org.junit.jupiter.api.Test;
import ru.zserg.jsubpair.model.Subtitle;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

public class ModelsTest {

    @Test
    public void SubtitleModelTest(){

        Subtitle sub = new Subtitle(1,
                LocalTime.of(0, 1, 10, 10^6),
                LocalTime.of(0, 1, 15, 10^6),
                "Text");
        assertEquals(1, sub.getNumber());
        assertEquals(LocalTime.of(0, 1, 10, 10^6), sub.getStart());
        assertEquals(LocalTime.of(0, 1, 15, 10^6), sub.getEnd());
        assertEquals("Text", sub.getText());
    }
}
