package com.phenom.Extractmetadatamp3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
public class ExtractMetadataMp3Application {
	@Autowired
	 SongInfo autowiredSongInfo;
	@Autowired
	 SongsRepository autowiredSongsRepository;
	static SongInfo songInfo;
	public static SongsRepository songsRepository;
	@PostConstruct
	public void init(){
		songInfo = this.autowiredSongInfo;
		songsRepository = this.autowiredSongsRepository;
	}
	public static void main(String[] args)throws Exception {
		SpringApplication.run(ExtractMetadataMp3Application.class, args);
		List<Songs> songs = songInfo.get();
	}

}
//172.17.0.3:5432