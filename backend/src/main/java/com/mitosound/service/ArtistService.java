package com.mitosound.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mitosound.model.Artist;
import com.mitosound.repository.ArtistRepository;

@Service 
public class ArtistService {
    
    private ArtistRepository artistRepository;

    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public List<Artist> getAllArtists() {
        return artistRepository.findAll();
    }

    public Artist createArtist(String name, String description) {
        Artist artist = new Artist(name, description);

        return artistRepository.save(artist);
    }
}
