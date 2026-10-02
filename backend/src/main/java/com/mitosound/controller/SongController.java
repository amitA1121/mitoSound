package com.mitosound.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mitosound.service.SongService;

@RestController
@RequestMapping("/api/songs")
public class SongController {

    private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }
    @GetMapping 
    public String getSong() {
        return songService.getSong();
    }

    @GetMapping("/{id}")
    public String getSongById(@PathVariable int id) {
        return "Song ID: " + id;
    } 
    @GetMapping(params = "name")
    public String getSongs(@RequestParam String name) {
        return "Searching: " + name;
    }
}
