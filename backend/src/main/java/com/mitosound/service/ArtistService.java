package com.mitosound.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mitosound.model.Artist;
import com.mitosound.repository.ArtistRepository;

@Service
public class ArtistService {

    private final ArtistRepository artistRepository;

    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public List<Artist> getAllArtists() {
        return artistRepository.findAll();
    }

    public Optional<Artist> getArtistByName(String name) {
        return artistRepository.findFirstByName(name);
    }

    public Artist createArtist(String name, String description) {
        return artistRepository.save(new Artist(name, description));
    }

    public boolean deleteArtistByName(String name) {
        Optional<Artist> artist = artistRepository.findFirstByName(name);
        artist.ifPresent(artistRepository::delete);
        return artist.isPresent();
    }
}
