package com.challange.UserTrackService.repository;

import com.challange.UserTrackService.domain.Track;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TrackRepository extends MongoRepository<Track,Integer> {

    Track findByTrackId(int trackId);
}
