package com.phenom.Extractmetadatamp3;
import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import com.mpatric.mp3agic.ID3v2;

import java.io.File;
import java.io.IOException;
public class Mp3Song {
    private File mp3;
    private Mp3File song;
    private String artist;
    private String version;
    private String track;
    private String title;
    private String album;
    private String genre;
    private String year;
    public Mp3Song(File mp3) throws InvalidDataException, UnsupportedTagException, IOException {
        this.mp3 = mp3;
        this.song = new Mp3File(this.mp3);
    }
    public void assignValues(){
        ID3v1 id3v1tag = null;
        ID3v2 id3v2tag = null;
        if(this.song.hasId3v1Tag()){
            id3v1tag = this.song.getId3v1Tag();
        }
        if(this.song.hasId3v2Tag()){
            id3v2tag = this.song.getId3v2Tag();
        }
        if(id3v1tag!=null){
            this.artist = id3v1tag.getArtist();
            this.album =  id3v1tag.getAlbum();
            this.genre = String.valueOf(id3v1tag.getGenre());
            this.year = id3v1tag.getYear();
            this.track = id3v1tag.getTrack();
            this.title = id3v1tag.getTitle();
            this.version = id3v1tag.getVersion();
        }
        else {
            this.artist = id3v2tag.getArtist();
            this.title = id3v2tag.getTitle();
            this.track = id3v2tag.getTrack();
            this.year = id3v2tag.getYear();
            this.album = id3v2tag.getAlbum();
            this.genre = String.valueOf(id3v2tag.getGenre());
            this.version = id3v2tag.getVersion();
        }
    }
    public void print(){
        System.out.println(this.artist);
        System.out.println(this.title);
        System.out.println(this.track);
        System.out.println(this.year);
        System.out.println(this.album);
        System.out.println(this.genre);
        System.out.println(this.version);
    }
}
