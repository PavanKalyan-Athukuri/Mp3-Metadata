package com.phenom.Extractmetadatamp3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.phenom.Extractmetadatamp3.ExtractMetadataMp3Application.songsRepository;

@RestController
@RequestMapping("/get")
public class SongsController {
    @GetMapping("/songs")
    public List<Songs>  getAllSongs(){
        return SongsService.getAllSongs();
    }
    /*@GetMapping("/songs/{duration}")
    public List<BigDecimal> getSong(@PathVariable BigDecimal duration){
      //  List<BigDecimal> list = new ArrayList<>();
      //  list = SongsService.getSongs(duration);
        //list = songsRepository.getSongs(duration.multiply(BigDecimal.valueOf(60)));
        //list = songsRepository.getSongs(duration.multiply(BigDecimal.valueOf(60)));
        //return list;
    }*/
}
