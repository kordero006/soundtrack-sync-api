package com.soundtracksync.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "media_works")
public class MediaWork {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MediaType type;

    private Integer releaseYear;

    private String directorOrDeveloper;

    private String coverImageUrl;

    @Column(length = 1000)
    private String synopsis;

    // Constructor vacío requerido por JPA
    public MediaWork() {
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MediaType getType() {
        return type;
    }

    public void setType(MediaType type) {
        this.type = type;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getDirectorOrDeveloper() {
        return directorOrDeveloper;
    }

    public void setDirectorOrDeveloper(String directorOrDeveloper) {
        this.directorOrDeveloper = directorOrDeveloper;
    }

    public String getCoverImageUrl() {
        return coverImageUrl;
    }

    public void setCoverImageUrl(String coverImageUrl) {
        this.coverImageUrl = coverImageUrl;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
}