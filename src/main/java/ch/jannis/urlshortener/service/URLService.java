package ch.jannis.urlshortener.service;

import ch.jannis.urlshortener.model.URL;

import java.util.List;

public interface URLService {
    URL generateUrl(String urlToShorten);
    List<URL> getUrlList();
    URL getURLByID(String id);

}
