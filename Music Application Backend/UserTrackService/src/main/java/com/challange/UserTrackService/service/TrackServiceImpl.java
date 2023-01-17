package com.challange.UserTrackService.service;

import com.challange.UserTrackService.domain.Artist;
import com.challange.UserTrackService.domain.Track;
import com.challange.UserTrackService.exception.ArtistAlreadyExistException;
import com.challange.UserTrackService.exception.ArtistNotFoundException;
import com.challange.UserTrackService.exception.TrackAlreadyExistException;
import com.challange.UserTrackService.exception.TrackNotFoundException;
import com.challange.UserTrackService.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Service
public class TrackServiceImpl implements TrackService{

    private TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl (TrackRepository trackRepository)
    {this.trackRepository=trackRepository;}

    @Override
    public Track addTrack(Track track) throws TrackAlreadyExistException {
        if(trackRepository.findById(track.getTrackId()).isPresent()){
            throw new TrackAlreadyExistException();
        }
        return trackRepository.insert(track);
    }

    @Override
    public Track addArtistForTrack(int trackId, Artist artist) throws ArtistAlreadyExistException {
        if(trackRepository.findById(artist.getArtistId()).isPresent()){
            throw new ArtistAlreadyExistException();
        }
        Track track=trackRepository.findByTrackId(trackId);
        if(track.getArtist()==null){
            track.setArtist(Arrays.asList(artist));
        }else {
            List<Artist> artists=track.getArtist();
            artists.add(artist);
            track.setArtist(artists);
        }
        return trackRepository.save(track);
    }


    @Override
    public List<Artist> getArtistOfTrack(int trackId) throws TrackNotFoundException {
        if(trackRepository.findById(trackId).isEmpty())
        {
            throw new TrackNotFoundException();
        }
        return trackRepository.findById(trackId).get().getArtist();
    }


    @Override
    public Track deleteTrack(int trackId,int artistId) throws TrackNotFoundException,ArtistNotFoundException{
        boolean result = false;
        if(trackRepository.findById(trackId).isEmpty())
        {
            throw new TrackNotFoundException();
        }
        Track track = trackRepository.findById(trackId).get();
        List<Artist> artistList = track.getArtist();
        result = artistList.removeIf(obj->obj.getArtistId()==artistId);
        if(!result)
        {
            throw new ArtistNotFoundException();
        }
        track.setArtist(artistList);
        return trackRepository.save(track);
    }

    @Override
    public Track updateTrackForUser(int trackId,Artist artist) throws TrackNotFoundException{
        if(trackRepository.findById(trackId).isEmpty()){
            throw new TrackNotFoundException();
        }
        Track track=trackRepository.findById(trackId).get();
        List<Artist> artists=track.getArtist();
        Iterator<Artist> iterator=artists.iterator();
        while (iterator.hasNext()){
            Artist artist1=iterator.next();
            if(artist1.getArtistId()==artist.getArtistId()){
                artist1.setArtistId(artist.getArtistId());
                artist1.setArtistName(artist.getArtistName());

            }
        }
        track.setArtist(artists);
        return trackRepository.save(track);
    }
}
