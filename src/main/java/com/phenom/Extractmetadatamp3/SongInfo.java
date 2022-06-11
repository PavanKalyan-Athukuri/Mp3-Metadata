package com.phenom.Extractmetadatamp3;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.BodyContentHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
@Component("autowiredSongInfo")
public class SongInfo {
    @Autowired
     SongsRepository songsRepository;
    @Autowired
    Songs s;
    public  List<Songs> get(String str) throws SAXException, TikaException,IOException {
        File[] listOfFiles = new File("/home/venkatapavanathukuri/IdeaProjects/Extract-metadata-mp3/folder").listFiles();
        List<Songs> songs = new ArrayList<>();
        AutoDetectParser parser = new AutoDetectParser();
        BodyContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        System.out.println("Length of Array "+listOfFiles.length);
        int k=1;
        for(File file :listOfFiles) {
            FileInputStream stream = new FileInputStream(file);
            ParseContext context = new ParseContext();
            parser.parse(stream, handler, metadata, context);
            String[] metadataNames = metadata.names();
            String arr[] = new String[9];
            int i=0;
            for (String name : metadataNames) {
                //System.out.println(name + "     " + metadata.get(name));
                arr[i] = metadata.get(name);
                i++;
            }

            songsRepository.save(new Songs(k,arr[1],arr[2],arr[3],arr[4],arr[5],arr[6],arr[7]));
            k++;
            //System.out.println("=========================");
        }
        return songs;
    }
}
