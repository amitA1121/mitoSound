package com.mitosound.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitosound.dto.CreateArtitstRequest;
import com.mitosound.model.Artist;
import com.mitosound.service.ArtistService;

@RestController 
@RequestMapping("/api/artists")
public class ArtistController {
    
    private final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping
    public List<Artist> getAllArtists() {
        return artistService.getAllArtists();
    }

    @PostMapping 
    public Artist createArtist(@RequestBody CreateArtitstRequest request) {
        return artistService.createArtist(
            request.name(),
            request.description()
        );
    }

}
