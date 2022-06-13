package com.phenom.Extractmetadatamp3;

import java.util.ArrayList;
import java.util.List;

import static com.phenom.Extractmetadatamp3.ExtractMetadataMp3Application.songsRepository;

public class SongsService {
    public static List<Songs> getAllSongs() {
        List<Songs> songs = new ArrayList<>();
        songsRepository.findAll().forEach(songs::add);
        return songs;
    }
}
