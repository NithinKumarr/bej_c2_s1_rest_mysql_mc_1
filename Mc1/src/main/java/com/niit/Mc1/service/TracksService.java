package com.niit.Mc1.service;

import com.niit.Mc1.domain.Tracks;

import java.util.List;

public interface TracksService {
    public Tracks addTracks(Tracks track);
    public List<Tracks> getAllTracks();
    public String deleteTracks(Integer trackId);
    public Tracks updateTracks(Tracks tracks);
    public List<Tracks> getAllTracksByTackArtist(String trackArtist);
}
