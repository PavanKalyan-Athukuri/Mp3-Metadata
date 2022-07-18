package com.phenom.Extractmetadatamp3;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.mp3.Mp3Parser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.math.BigDecimal;
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
        ContentHandler handler = new DefaultHandler();
        Metadata metadata = new Metadata();
       // System.out.println("Length of Array "+listOfFiles.length);
        int k=1;
        for(File file :listOfFiles) {
            FileInputStream stream = new FileInputStream(file);
           /* try{
            Mp3Song mp3Song = new Mp3Song(file);
            mp3Song.print();}
            catch (Exception e){
                System.out.println(e);
            }*/
            ParseContext context = new ParseContext();
            Parser parse  = new Mp3Parser();
            parse.parse(stream, handler, metadata, context);
            System.out.println("----------------------------------------------");
            //System.out.println("Title: " + metadata.get("title"));
            //System.out.println("Artists: " + metadata.get("xmpDM:artist"));
            //System.out.println("Composer : "+metadata.get("xmpDM:composer"));
            //System.out.println("Genre : "+metadata.get("xmpDM:genre"));
            //System.out.println("Album : "+metadata.get("xmpDM:album"));
            String[] metadataNames = metadata.names();
            String[] metadatainfo = new String[9];
            int i=0;
            BigDecimal time=BigDecimal.ZERO;
            for (String name: metadataNames) {
                if(i==5){
                     time = (new BigDecimal(metadata.get(name)));
                    System.out.println(name +"   "+metadata.get(name));
                     i++;
                }else{
                metadatainfo[i] = metadata.get(name);
                System.out.println(name +"   "+metadata.get(name));
                i++;}
            }
            int j=0;
            s.setId(k);
            s.setAudioSampleRate(metadatainfo[j++]);
            s.setChannels(metadatainfo[j++]);
            s.setAudioCompressor(metadatainfo[j++]);
            s.setAudioChannelType(metadatainfo[j++]);
            s.setVersion(metadatainfo[j++]);
            s.setDuration(time);
            j++;
            s.setContentType(metadatainfo[j++]);
            songsRepository.save(s);
            k++;
        }
        return songs;
    }
}
