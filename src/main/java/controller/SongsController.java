package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.phenom.Extractmetadatamp3.Songs;
import service.SongsService;

import java.util.List;
@RestController
public class SongsController {
    @GetMapping("/get")
    public List<Songs>  getAllSongs(){
        return SongsService.getAllSongs();
    }
}
