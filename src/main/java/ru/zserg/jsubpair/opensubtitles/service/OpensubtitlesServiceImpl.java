package ru.zserg.jsubpair.opensubtitles.service;

import lombok.extern.slf4j.Slf4j;
import ru.zserg.jsubpair.model.SubPair;
import ru.zserg.jsubpair.opensubtitles.OpensubtitlesServiceException;
import ru.zserg.jsubpair.opensubtitles.model.OsServerInfo;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;

@Slf4j
public class OpensubtitlesServiceImpl implements OpensubtitlesService {
    private static final String XMLRPC_URL = "https://api.opensubtitles.org/xml-rpc";

    public OsServerInfo getServerInfo() throws OpensubtitlesServiceException {
        try {
            XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
            config.setServerURL(new URL(XMLRPC_URL));
            XmlRpcClient client = new XmlRpcClient();
            client.setConfig(config);

            Map<String, Object> result = (Map<String, Object>) client.execute("ServerInfo", new ArrayList());
            OsServerInfo info = new OsServerInfo(result);
            return info;
        } catch (Exception e) {
            throw new OpensubtitlesServiceException("Get ServerInfo exception", e);
        }

    }

    public SubPair downloadSub(String imdb, String language) throws OpensubtitlesServiceException {
        return null;
    }

}
