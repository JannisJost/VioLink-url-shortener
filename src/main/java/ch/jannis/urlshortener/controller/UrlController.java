package ch.jannis.urlshortener.controller;

import ch.jannis.urlshortener.model.URL;
import ch.jannis.urlshortener.service.URLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RequestMapping(value = "/api")
public class UrlController {
    @Autowired
    URLService urlService;

    @PostMapping("get-short-url")
    public String generateURL(@RequestBody String url) {
        URL savedUrl = urlService.generateUrl(url);
        return "http://localhost:4200/" + savedUrl.getShortenedID();
    }

    @PostMapping("get-url-by-id")
    public URL getURLByID(@RequestBody String id) {
        return urlService.getURLByID(id);
    }
}
