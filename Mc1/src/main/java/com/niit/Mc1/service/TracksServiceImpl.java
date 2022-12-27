package com.niit.Mc1.service;

import com.niit.Mc1.domain.Tracks;
import com.niit.Mc1.repository.TracksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TracksServiceImpl implements TracksService{
    @Autowired
    TracksRepository tracksRepository;
    @Override
    public Tracks addTracks(Tracks track) {
        if(tracksRepository.findByTrackId(track.getTrackId()).isEmpty()){
            return tracksRepository.save(track);
        }
        return null;
    }

    @Override
    public List<Tracks> getAllTracks() {
        return tracksRepository.findAll();
    }

    @Override
    public String deleteTracks(Integer trackId) {
        if(tracksRepository.findByTrackId(trackId).isEmpty()){
            return "Track does not exist";
        }
        tracksRepository.deleteById(trackId);
        return "track deleted successfully";
    }

    @Override
    public Tracks updateTracks(Tracks tracks) {
        if(tracksRepository.findByTrackId(tracks.getTrackId()).isEmpty()){
            return null;
        }
        Tracks tempTrack=tracksRepository.findByTrackId(tracks.getTrackId()).get(0);
        tempTrack.setTrackName(tracks.getTrackName());
        tempTrack.setTrackArtist(tracks.getTrackArtist());
        tempTrack.setTrackComments(tracks.getTrackComments());
        tempTrack.setTrackRating(tracks.getTrackRating());
        return tracksRepository.save(tempTrack);

    }

    @Override
    public List<Tracks> getAllTracksByTackArtist(String trackArtist) {
        return tracksRepository.findByTrackArtist(trackArtist);
    }
}
