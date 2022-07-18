package com.phenom.Extractmetadatamp3;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

import static com.phenom.Extractmetadatamp3.ExtractMetadataMp3Application.songsRepository;

public class SongsService {
    public static List<Songs> getAllSongs() {
        List<Songs> songs = new ArrayList<>();
        songsRepository.findAll().forEach(songs::add);
        return songs;
    }
    //@Query("select * from Songs s where s.duration <= ?1")
    //public static List<Songs>getSongs(@Param("duration")int duration);
}
