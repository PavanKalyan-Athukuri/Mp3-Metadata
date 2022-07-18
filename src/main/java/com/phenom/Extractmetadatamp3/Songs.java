package com.phenom.Extractmetadatamp3;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "songs")
@Component("s")
public class Songs {
    @Column
    @Id
    private int id;

    public Songs() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column
    private String audioSampleRate;
    @Column
    private String channels;
    @Column
    private String audioCompressor;
    @Column
    private String audioChannelType;
    @Column
    private String version;
    @Column
    private BigDecimal duration;
    @Column
    private String contentType;
    public Songs(int id,String audioSampleRate,String channels,String audioCompressor,String audioChannelType,String version,BigDecimal duration,String contentType){
        this.id = id;
        this.audioSampleRate = audioSampleRate;
        this.channels = channels;
        this.audioCompressor = audioCompressor;
        this.audioChannelType = audioChannelType;
        this.version = version;
        this.duration = duration;
        this.contentType = contentType;
    }

    public String getAudioSampleRate() {
        return audioSampleRate;
    }

    public void setAudioSampleRate(String audioSampleRate) {
        this.audioSampleRate = audioSampleRate;
    }

    public String getChannels() {
        return channels;
    }

    public void setChannels(String channels) {
        this.channels = channels;
    }

    public String getAudioCompressor() {
        return audioCompressor;
    }

    public void setAudioCompressor(String audioCompressor) {
        this.audioCompressor = audioCompressor;
    }

    public String getAudioChannelType() {
        return audioChannelType;
    }

    public void setAudioChannelType(String audioChannelType) {
        this.audioChannelType = audioChannelType;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public BigDecimal getDuration() {
        return duration;
    }

    public void setDuration(BigDecimal duration) {
        this.duration = duration;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}