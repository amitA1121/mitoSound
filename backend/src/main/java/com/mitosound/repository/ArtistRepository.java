package com.mitosound.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitosound.model.Artist;
import java.util.Optional;
import java.util.UUID;

public interface ArtistRepository extends JpaRepository<Artist, UUID> {
    Optional<Artist> findFirstByName(String name);
    boolean artistExistsByName(String name);
}
