package ch.jannis.urlshortener.dao;

import ch.jannis.urlshortener.model.URL;

import java.util.List;

public interface URLDao {
    URL generateUrl(URL urlToShorten);
    List<URL> getUrlList();
     int getLastID();
     URL getURLByID(String id);
}
