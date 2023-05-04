package ch.jannis.urlshortener.service;

import ch.jannis.urlshortener.dao.URLDao;
import ch.jannis.urlshortener.math.IDShortener;
import ch.jannis.urlshortener.model.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class URLServiceImp implements URLService {
    @Autowired
    URLDao urlDao;

    IDShortener idShortener = new IDShortener();


    @Override
    public URL generateUrl(String urlToShorten) {
        URL url = new URL();
        int nextID = urlDao.getLastID() + 1;
        url.setShortenedID(idShortener.getValue(nextID));
        url.setUrl(urlToShorten);
        return urlDao.generateUrl(url);
    }

    @Override
    public List<URL> getUrlList() {
        return null;
    }

    @Override
    public URL getURLByID(String id) {
        return urlDao.getURLByID(id);
    }
}
