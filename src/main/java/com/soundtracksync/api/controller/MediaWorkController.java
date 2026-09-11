package com.soundtracksync.api.controller;

import com.soundtracksync.api.model.MediaWork;
import com.soundtracksync.api.service.MediaWorkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.soundtracksync.api.dto.MediaWorkRequest;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/media-works")
@CrossOrigin(origins = "*") // Permite peticiones desde el frontend
public class MediaWorkController {

    private final MediaWorkService mediaWorkService;

    public MediaWorkController(MediaWorkService mediaWorkService) {
        this.mediaWorkService = mediaWorkService;
    }

    @GetMapping
    public List<MediaWork> getAll() {
        return mediaWorkService.getAllMediaWorks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MediaWork> getById(@PathVariable Long id) {
        return mediaWorkService.getMediaWorkById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /*@PostMapping
    public ResponseEntity<MediaWork> create(@RequestBody MediaWork mediaWork) {
        MediaWork created = mediaWorkService.createMediaWork(mediaWork);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }*/

    @PostMapping
    public ResponseEntity<MediaWork> create(
            @Valid @RequestBody MediaWorkRequest request) {

        MediaWork mediaWork = toEntity(request);
        MediaWork created = mediaWorkService.createMediaWork(mediaWork);

        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    /*@PutMapping("/{id}")
    public ResponseEntity<MediaWork> update(@PathVariable Long id, @RequestBody MediaWork mediaWork) {
        return mediaWorkService.updateMediaWork(id, mediaWork)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }*/

    @PutMapping("/{id}")
    public ResponseEntity<MediaWork> update(
            @PathVariable Long id,
            @Valid @RequestBody MediaWorkRequest request) {

        MediaWork updatedMediaWork = toEntity(request);

        return mediaWorkService.updateMediaWork(id, updatedMediaWork)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (mediaWorkService.deleteMediaWork(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    private MediaWork toEntity(MediaWorkRequest request) {
        MediaWork mediaWork = new MediaWork();

        mediaWork.setTitle(request.getTitle());
        mediaWork.setType(request.getType());
        mediaWork.setReleaseYear(request.getReleaseYear());
        mediaWork.setDirectorOrDeveloper(request.getDirectorOrDeveloper());
        mediaWork.setCoverImageUrl(request.getCoverImageUrl());
        mediaWork.setSynopsis(request.getSynopsis());

        return mediaWork;
    }
}