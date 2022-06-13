package com.phenom.Extractmetadatamp3;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.BodyContentHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
@Component("autowiredSongInfo")
public class SongInfo {
    @Autowired
    public SongsRepository songsRepository;
    @Autowired
    Songs s;
    public File[] getSongs(){
        File folder = new File("/home/venkatapavanathukuri/IdeaProjects/Extract-metadata-mp3/folder");
        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".mp3");
            }
        };
        return folder.listFiles(filter);
    }
    public  List<Songs> get() throws SAXException, TikaException,IOException {
        SongInfo songInfo = new SongInfo();
        File[] listOfFiles = songInfo.getSongs();
        List<Songs> songs = new ArrayList<>();
        AutoDetectParser parser = new AutoDetectParser();
        BodyContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();
       // System.out.println("Length of Array "+listOfFiles.length);
        int k=1;
        for(File file :listOfFiles) {
            FileInputStream stream = new FileInputStream(file);
            ParseContext context = new ParseContext();
            parser.parse(stream, handler, metadata, context);
            String[] metadataNames = metadata.names();
            String arr[] = new String[9];
            int i=0;
            for (String name : metadataNames) {
                arr[i] = metadata.get(name);
                i++;
            }

            songsRepository.save(new Songs(k,arr[1],arr[2],arr[3],arr[4],arr[5],arr[6],arr[7]));
            k++;
        }
        return songs;
    }
}
