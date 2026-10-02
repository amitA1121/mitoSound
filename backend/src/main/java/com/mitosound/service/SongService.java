package com.mitosound.service;

import org.springframework.stereotype.Service;

@Service 
public class SongService {

    public String getSong() {
        return "Song from service!";
    }
}
