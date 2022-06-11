package service;

import com.phenom.Extractmetadatamp3.Songs;

import java.util.ArrayList;
import java.util.List;
import com.phenom.Extractmetadatamp3.SongsRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class SongsService {
    @Autowired
     SongsRepository autowiredSongsRepository;
    static SongsRepository songsRepository;
    public void init(){
        songsRepository = this.autowiredSongsRepository;
    }
    public static List<Songs> getAllSongs() {
        List<Songs> songs = new ArrayList<>();
        songsRepository.findAll().forEach(songs::add);
        return songs;
    }
}
