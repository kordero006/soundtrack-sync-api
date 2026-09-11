package com.soundtracksync.api.repository;

import com.soundtracksync.api.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackRepository extends JpaRepository<Track, Long> {
}