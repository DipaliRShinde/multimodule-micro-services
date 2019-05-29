package com.stackroute.Muzix.service;

import com.stackroute.Muzix.domain.Track;
import com.stackroute.Muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.Muzix.exceptions.TrackNotFoundException;

import java.util.List;

public interface TrackService {

    Track saveTrack(Track track) throws TrackAlreadyExistsException;

    List<Track> showAllTrack();

    Track updateComment(Track track) throws TrackNotFoundException;

    boolean deleteTrack(Track track) throws TrackNotFoundException;
}
