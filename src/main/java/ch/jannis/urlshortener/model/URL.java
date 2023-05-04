package ch.jannis.urlshortener.model;

import jakarta.persistence.*;

@Entity
public class URL {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String shortenedID;

    private String url;

    public String getShortenedID() {
        return shortenedID;
    }

    public void setShortenedID(String shortenedID) {
        this.shortenedID = shortenedID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
