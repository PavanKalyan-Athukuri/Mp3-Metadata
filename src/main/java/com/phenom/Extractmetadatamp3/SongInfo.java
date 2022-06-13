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
        File folder = new File("/home/venkatapavanathukuri/IdeaProjects/Mp3-Metadata/folder");
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
            String[] metadatainfo = new String[9];
            int i=0;
            for (String name: metadataNames) {
                metadatainfo[i] = metadata.get(name);
                System.out.println(name +"   "+metadata.get(name));
                i++;
            }
            int j=1;
            s.setId(k);
            s.setAudioSampleRate(metadatainfo[j++]);
            s.setChannels(metadatainfo[j++]);
            s.setAudioCompressor(metadatainfo[j++]);
            s.setAudioChannelType(metadatainfo[j++]);
            s.setVersion(metadatainfo[j++]);
            s.setDuration(metadatainfo[j++]);
            s.setContentType(metadatainfo[j++]);
            songsRepository.save(s);
            k++;
        }
        return songs;
    }
}
