package ru.zserg.jsubpair;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.zserg.jsubpair.model.SubPair;
import ru.zserg.jsubpair.opensubtitles.OpensubtitlesServiceException;
import ru.zserg.jsubpair.opensubtitles.model.OsServerInfo;
import ru.zserg.jsubpair.opensubtitles.service.OpensubtitlesService;
import ru.zserg.jsubpair.opensubtitles.service.OpensubtitlesServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class OpensubtitlesServiceTest {
//    @Test
//    public void searchByImdb(){
//        OsServerInfo osServerInfo = opensubtitlesService.getServerInfo();
//        assertEquals("http://www.opensubtitles.org", osServerInfo.getUrl());
//    }

    @Test
    public void serverInfoTest(){
        OpensubtitlesService service = new OpensubtitlesServiceImpl();
        try {
            OsServerInfo osServerInfo = service.getServerInfo();
            assertEquals("http://api.opensubtitles.org/xml-rpc", osServerInfo.getXmlrpcUrl());
        }catch (OpensubtitlesServiceException e){
            log.error("Error", e);
        }
    }
}
