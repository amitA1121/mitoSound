package com.mitosound.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitosound.model.Artist;
import java.util.UUID;

public interface ArtistRepository extends JpaRepository<Artist, UUID> {
    }
