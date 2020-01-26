package ru.zserg.jsubpair.opensubtitles.service;

import ru.zserg.jsubpair.model.SubPair;
import ru.zserg.jsubpair.opensubtitles.OpensubtitlesServiceException;
import ru.zserg.jsubpair.opensubtitles.model.OsServerInfo;

public interface OpensubtitlesService {
    public OsServerInfo getServerInfo() throws OpensubtitlesServiceException;
    public SubPair downloadSub(String imdb, String language) throws OpensubtitlesServiceException;
}
