package com.phenom.Extractmetadatamp3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ExtractMetadataMp3Application {
	@Autowired
	 SongInfo autowiredSongInfo;
	@Autowired
	 SongsRepository autowiredSongsRepository;
	static SongInfo songInfo;
	static SongsRepository songsRepository;
	@PostConstruct
	public void init(){
		songInfo = this.autowiredSongInfo;
		songsRepository = this.autowiredSongsRepository;
	}
	public static void main(String[] args)throws Exception {
		SpringApplication.run(ExtractMetadataMp3Application.class, args);
		String path = "/folder";
		List<Songs> songs = songInfo.get(path);
		ArrayList<Songs> songs1 = new ArrayList<>();
		songsRepository.findAll().forEach(songs1::add);
		for(int i=0;i<songs1.size();i++){
			System.out.println(songs1.get(i).getAudioChannelType());
		}
	}

}
