package com.challange.UserTrackService.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Track {
    @Id
    private int trackId;
    private String trackName;
    private List<Artist> artist;

    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public List<Artist> getArtist() {
        return artist;
    }

    public void setArtist(List<Artist> artist) {
        this.artist = artist;
    }

    public Track() {
    }

    public Track(int trackId, String trackName, List<Artist> artist) {
        this.trackId = trackId;
        this.trackName = trackName;
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "Track{" +
                "trackId=" + trackId +
                ", trackName='" + trackName + '\'' +
                ", artist=" + artist +
                '}';
    }
}
