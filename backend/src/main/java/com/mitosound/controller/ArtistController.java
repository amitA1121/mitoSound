package com.mitosound.controller;

import java.util.List;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

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

    //get
    @GetMapping
    public List<Artist> getAllArtists() {
        return artistService.getAllArtists();
    }

    @GetMapping(params = "name")
    public ResponseEntity<?> getArtistByName(@RequestParam String name) {
        return artistService.getArtistByName(name)
            .<ResponseEntity<?>>map(ResponseEntity::ok)
            .orElseGet(() -> artistNotFound(name));
    }

    //create
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Artist createArtist(@RequestBody CreateArtitstRequest request) {
        return artistService.createArtist(request.name(), request.description());
    }

    //remove
    @DeleteMapping(params = "name")
    public ResponseEntity<String> deleteArtistByName(@RequestParam String name) {
        return artistService.deleteArtistByName(name)
            ? ResponseEntity.ok("Artist '" + name + "' deleted")
            : artistNotFound(name);
    }

    //update
    @PutMapping(params = "name")
    public ResponseEntity<?> updateArtist(@RequestParam String name, @RequestBody CreateArtitstRequest request) {
        return artistService.updateArtist(name, request.name(), request.description())
            .<ResponseEntity<?>>map(ResponseEntity::ok)
            .orElseGet(() -> artistNotFound(name));
    }

    private ResponseEntity<String> artistNotFound(String name) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body("Artist '" + name + "' not found");
    }
}
