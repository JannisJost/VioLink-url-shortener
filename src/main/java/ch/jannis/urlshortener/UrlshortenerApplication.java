package ch.jannis.urlshortener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"ch.jannis.urlshortener.controller","ch.jannis.urlshortener.config", "ch.jannis.urlshortener.dao","ch.jannis.urlshortener.service"})
public class UrlshortenerApplication {

    public static void main(String[] args) {
        SpringApplication.run(UrlshortenerApplication.class, args);
    }

}
