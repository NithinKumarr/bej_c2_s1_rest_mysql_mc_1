package com.niit.Mc1.repository;

import com.niit.Mc1.domain.Tracks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TracksRepository extends JpaRepository<Tracks,Integer> {
public List<Tracks>findByTrackArtist(String trackArtist);
public List<Tracks>findByTrackId(Integer trackId);
}
