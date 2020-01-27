package ru.zserg.jsubpair;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import ru.zserg.jsubpair.opensubtitles.OpensubtitlesServiceException;
import ru.zserg.jsubpair.opensubtitles.client.OpensubtitlesClient;
import ru.zserg.jsubpair.opensubtitles.client.OpensubtitlesClientImpl;
import ru.zserg.jsubpair.opensubtitles.model.LoginResult;
import ru.zserg.jsubpair.opensubtitles.model.OsServerInfo;
import ru.zserg.jsubpair.opensubtitles.model.SearchSubtitlesResult;
import ru.zserg.jsubpair.opensubtitles.service.OpensubtitlesService;
import ru.zserg.jsubpair.opensubtitles.service.OpensubtitlesServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class OpensubtitlesClientTest {

    @Test
    public void serverInfoTest(){
        OpensubtitlesClient client = new OpensubtitlesClientImpl();
        try {
            OsServerInfo osServerInfo = client.getServerInfo();
            assertEquals("http://api.opensubtitles.org/xml-rpc", osServerInfo.getXmlrpcUrl());
        }catch (OpensubtitlesServiceException e){
            log.error("Error", e);
        }
    }

    @Test
    public void loginTest(){
        OpensubtitlesClient client = new OpensubtitlesClientImpl();
        try {
            LoginResult token = client.login("TemporaryUserAgent");
            assertEquals(true, token.getToken().get().length() > 0);
        }catch (OpensubtitlesServiceException e){
            log.error("Error", e);
        }
    }

    @Test
    public void searchSubtitlesByImdbTest(){
        OpensubtitlesClient client = new OpensubtitlesClientImpl();
        try {
            String token = client.login("TemporaryUserAgent").getToken().get();
            SearchSubtitlesResult result = client.searchSubtitlesByImdb(token, "1234", "en");
            assertEquals("gold is not all", result.getData().getMovieName());
        }catch (OpensubtitlesServiceException e){
            log.error("Error", e);
        }
    }
}
