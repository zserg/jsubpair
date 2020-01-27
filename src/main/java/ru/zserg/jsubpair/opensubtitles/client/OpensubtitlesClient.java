package ru.zserg.jsubpair.opensubtitles.client;

import ru.zserg.jsubpair.model.SubPair;
import ru.zserg.jsubpair.opensubtitles.OpensubtitlesServiceException;
import ru.zserg.jsubpair.opensubtitles.model.LoginResult;
import ru.zserg.jsubpair.opensubtitles.model.OsServerInfo;
import ru.zserg.jsubpair.opensubtitles.model.SearchSubtitlesResult;

public interface OpensubtitlesClient {
    public OsServerInfo getServerInfo() throws OpensubtitlesServiceException;
    public LoginResult login(String userAgent) throws OpensubtitlesServiceException;
    public SearchSubtitlesResult searchSubtitlesByImdb(String token, String imdb, String language) throws OpensubtitlesServiceException;
}
