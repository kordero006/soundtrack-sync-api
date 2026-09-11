package com.soundtracksync.api.dto;

import com.soundtracksync.api.model.MediaType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class MediaWorkRequest {

    @NotBlank(message = "El título es obligatorio")
    @Size(max = 150, message = "El título no puede superar los 150 caracteres")
    private String title;

    @NotNull(message = "El tipo de obra es obligatorio")
    private MediaType type;

    @Min(value = 1888, message = "El año debe ser igual o posterior a 1888")
    @Max(value = 2100, message = "El año no puede ser posterior a 2100")
    private Integer releaseYear;

    @Size(max = 150, message = "El director o desarrollador no puede superar los 150 caracteres")
    private String directorOrDeveloper;

    @Size(max = 500, message = "La URL de portada no puede superar los 500 caracteres")
    private String coverImageUrl;

    @Size(max = 1000, message = "La sinopsis no puede superar los 1000 caracteres")
    private String synopsis;

    public MediaWorkRequest() {
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