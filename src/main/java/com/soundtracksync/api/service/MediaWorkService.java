package com.soundtracksync.api.service;

import com.soundtracksync.api.model.MediaWork;
import com.soundtracksync.api.repository.MediaWorkRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MediaWorkService {

    private final MediaWorkRepository mediaWorkRepository;

    // Inyección de dependencias por constructor (buena práctica recomendada)
    public MediaWorkService(MediaWorkRepository mediaWorkRepository) {
        this.mediaWorkRepository = mediaWorkRepository;
    }

    public List<MediaWork> getAllMediaWorks() {
        return mediaWorkRepository.findAll();
    }

    public Optional<MediaWork> getMediaWorkById(Long id) {
        return mediaWorkRepository.findById(id);
    }

    public MediaWork createMediaWork(MediaWork mediaWork) {
        return mediaWorkRepository.save(mediaWork);
    }

    public Optional<MediaWork> updateMediaWork(Long id, MediaWork updatedMediaWork) {
        return mediaWorkRepository.findById(id).map(existingWork -> {
            existingWork.setTitle(updatedMediaWork.getTitle());
            existingWork.setType(updatedMediaWork.getType());
            existingWork.setReleaseYear(updatedMediaWork.getReleaseYear());
            existingWork.setDirectorOrDeveloper(updatedMediaWork.getDirectorOrDeveloper());
            existingWork.setCoverImageUrl(updatedMediaWork.getCoverImageUrl());
            existingWork.setSynopsis(updatedMediaWork.getSynopsis());
            return mediaWorkRepository.save(existingWork);
        });
    }

    public boolean deleteMediaWork(Long id) {
        if (mediaWorkRepository.existsById(id)) {
            mediaWorkRepository.deleteById(id);
            return true;
        }
        return false;
    }
}