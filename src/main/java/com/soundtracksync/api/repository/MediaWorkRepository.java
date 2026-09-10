package com.soundtracksync.api.repository;

import com.soundtracksync.api.model.MediaWork;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaWorkRepository extends JpaRepository<MediaWork, Long> {
}