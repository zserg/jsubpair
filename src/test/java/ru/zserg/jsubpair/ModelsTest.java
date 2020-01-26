package ru.zserg.jsubpair;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.zserg.jsubpair.model.Sub;
import ru.zserg.jsubpair.model.SubPair;
import ru.zserg.jsubpair.model.Subtitle;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ModelsTest {

    @Test
    public void SubtitleModelTest() {
        Subtitle sub = new Subtitle(1, LocalTime.parse("00:01:10"), LocalTime.parse("00:01:15"), "Text");
        assertEquals(1, sub.getNumber());
        assertEquals(LocalTime.parse("00:01:10"), sub.getStart());
        assertEquals(LocalTime.parse("00:01:15"), sub.getEnd());
        assertEquals("Text", sub.getText());
    }

    @Test
    public void SubtitleStartEndTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Subtitle sub = new Subtitle(1, LocalTime.parse("00:02:10"), LocalTime.parse("00:01:15"), "Text");
        });

    }

    @Test
    public void SubModelTest() {
        List<Subtitle> subs = new ArrayList<>();
        subs.add(new Subtitle(1, LocalTime.parse("00:01:10"), LocalTime.parse("00:01:15"), "Text1"));
        Sub sub = new Sub("Title", "en", "01234", "1972", subs);

        assertEquals("Title", sub.getTitle());
        assertEquals(LocalTime.parse("00:01:10"), sub.getSubs().get(0).getStart());

    }

    @Test
    public void SubPairModelTest() {
        List<Subtitle> subsA = new ArrayList<>();
        subsA.add(new Subtitle(1, LocalTime.parse("00:01:10"), LocalTime.parse("00:01:15"), "Text1"));
        Sub subA = new Sub("Title1", "en", "01234", "1972", subsA);

        List<Subtitle> subsB = new ArrayList<>();
        subsB.add(new Subtitle(1, LocalTime.parse("00:02:10"), LocalTime.parse("00:02:15"), "Text2"));
        Sub subB = new Sub("Title2", "ru", "01234", "1972", subsB);

        SubPair subPair = new SubPair(subA, subB);

        assertEquals("Title1", subPair.getSubA().getTitle());

    }
}
