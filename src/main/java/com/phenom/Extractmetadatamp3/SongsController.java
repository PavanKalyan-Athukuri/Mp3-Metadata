package com.phenom.Extractmetadatamp3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/get")
public class SongsController {
    @GetMapping("/songs")
    public List<Songs>  getAllSongs(){
        return SongsService.getAllSongs();
    }
    @GetMapping("/String")
    public String method(){
        return "Kalyan";
    }
}
