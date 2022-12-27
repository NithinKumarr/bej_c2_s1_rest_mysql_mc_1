package com.niit.Mc1.controller;

import com.niit.Mc1.domain.Tracks;
import com.niit.Mc1.service.TracksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class TracksController {
    TracksService tracksService;
    @Autowired
    public TracksController(TracksService tracksService) {
        this.tracksService = tracksService;
    }
    @PostMapping("/track")
    public ResponseEntity<?>saveTrack(@RequestBody Tracks tracks){
        return new ResponseEntity<>(tracksService.addTracks(tracks), HttpStatus.CREATED);
    }
    @GetMapping("/track")
    public ResponseEntity<?>getAllTrack(){
        return new ResponseEntity<>(tracksService.getAllTracks(),HttpStatus.OK);
    }
    @DeleteMapping("track/{id}")
    public ResponseEntity<?>deleteTrack(@PathVariable Integer id){
        return new ResponseEntity<>(tracksService.deleteTracks(id),HttpStatus.OK);
    }
    @PutMapping("/trackupdate")
    public ResponseEntity<?>updateTrack(@RequestBody Tracks tracks){
        return new ResponseEntity<>(tracksService.updateTracks(tracks),HttpStatus.OK);
    }
    @GetMapping("/Trackartist/Artist/{artist}")
    public ResponseEntity<?>getAllTracksWithArtist(@PathVariable String artist){
        return new ResponseEntity<>(tracksService.getAllTracksByTackArtist(artist),HttpStatus.FOUND);
    }
}
