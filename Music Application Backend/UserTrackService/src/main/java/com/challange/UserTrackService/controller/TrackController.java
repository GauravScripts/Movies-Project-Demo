package com.challange.UserTrackService.controller;

import com.challange.UserTrackService.domain.Artist;
import com.challange.UserTrackService.domain.Track;
import com.challange.UserTrackService.exception.ArtistAlreadyExistException;
import com.challange.UserTrackService.exception.ArtistNotFoundException;
import com.challange.UserTrackService.exception.TrackAlreadyExistException;
import com.challange.UserTrackService.exception.TrackNotFoundException;
import com.challange.UserTrackService.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usertrackservice/v1/")
public class TrackController {

    ResponseEntity responseEntity;
    private TrackService trackService;

    @Autowired
    public TrackController (TrackService trackService)
    {
        this.trackService=trackService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> insertTrack(@RequestBody Track track) throws TrackAlreadyExistException {
        try {
            track.setArtist(new ArrayList<>());
            Track track1 = trackService.addTrack(track);
            responseEntity = new ResponseEntity<>(track1, HttpStatus.OK);
        }catch (TrackAlreadyExistException e){
            throw new TrackAlreadyExistException();
        }
        return responseEntity;
    }

    @PutMapping("/track/addArtist/{trackId}")
    public ResponseEntity<?> addArtistForTrack(@PathVariable("trackId") int trackId, @RequestBody Artist artist) throws ArtistAlreadyExistException {

        try{
            Track track=trackService.addArtistForTrack(trackId,artist);
            responseEntity=new ResponseEntity<>(track,HttpStatus.OK);

        }  catch (ArtistAlreadyExistException e) {
            throw new ArtistAlreadyExistException();
        }

        return responseEntity;
    }


    @GetMapping("/track/artists/{trackId}")
    public ResponseEntity<?> getArtistForUser(@PathVariable int trackId) throws TrackNotFoundException {
        try{
            responseEntity = new ResponseEntity<>(trackService.getArtistOfTrack(trackId), HttpStatus.OK);
        }catch(TrackNotFoundException e){
            throw new TrackNotFoundException();
        }
        catch (Exception e){
            responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @DeleteMapping("/track/deleteTrack/{trackId}/{artistId}")
    public ResponseEntity<?> deleteProductForUser(@PathVariable(value = "trackId")int trackId,@PathVariable(value = "artistId") int artistId) throws TrackNotFoundException, ArtistNotFoundException {
        ResponseEntity responseEntity = null;
        try{
            responseEntity = new ResponseEntity<>(trackService.deleteTrack(trackId,artistId), HttpStatus.OK);
        }catch (TrackNotFoundException e){
            throw new TrackNotFoundException();
        }catch (ArtistNotFoundException e){
            throw new ArtistNotFoundException();
        } catch(Exception e){
            responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @PutMapping("/track/updateTrack/{trackId}")
    public ResponseEntity<?> updateTrackForUser(@PathVariable int trackId,@RequestBody Artist artist) throws TrackNotFoundException {
        ResponseEntity responseEntity = null;
        try{
            responseEntity = new ResponseEntity<>(trackService.updateTrackForUser(trackId,artist), HttpStatus.CREATED);
        }catch (TrackNotFoundException e){
            throw new TrackNotFoundException();
        }catch (Exception e){
            responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
