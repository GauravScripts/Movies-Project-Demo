package com.challange.UserTrackService.service;

import com.challange.UserTrackService.domain.Artist;
import com.challange.UserTrackService.domain.Track;

import com.challange.UserTrackService.exception.ArtistAlreadyExistException;
import com.challange.UserTrackService.exception.ArtistNotFoundException;
import com.challange.UserTrackService.exception.TrackAlreadyExistException;
import com.challange.UserTrackService.exception.TrackNotFoundException;


import java.util.List;

public interface TrackService {

    Track addTrack(Track track) throws TrackAlreadyExistException;

    Track addArtistForTrack(int artistId, Artist artist) throws ArtistAlreadyExistException;

   // List<Artist> getAllTracks(int trackId) throws TrackNotFoundException, ArtistNotFoundException;

    public List<Artist> getArtistOfTrack(int trackId) throws TrackNotFoundException;

    public Track deleteTrack(int trackId,int artistId) throws TrackNotFoundException,ArtistNotFoundException ;

    public Track updateTrackForUser(int trackId,Artist artist) throws TrackNotFoundException;
}
