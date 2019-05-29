package com.stackroute.Muzix.controller;

import com.stackroute.Muzix.domain.Track;
import com.stackroute.Muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.Muzix.exceptions.TrackNotFoundException;
import com.stackroute.Muzix.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class TrackControl {

    @Autowired
    private TrackService trackService;

    public TrackControl(TrackService trackService) {
        this.trackService = trackService;
    }

    public void setTrackService(TrackService trackService) {
        this.trackService = trackService;
    }

    @RequestMapping(value = "trackcreate", method = RequestMethod.POST)
    public ResponseEntity<Track> saveTrack(@RequestBody Track track) {
        ResponseEntity responseEntity;
        try {
            Track track1 = trackService.saveTrack(track);
            responseEntity = new ResponseEntity<Track>(track, HttpStatus.CREATED);
        } catch (TrackAlreadyExistsException e) {
            System.out.println(e.getMessage());
            responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
            e.printStackTrace();
        }
        return responseEntity;
    }

    @RequestMapping(value = "trackdisplay", method = RequestMethod.GET)
    public ResponseEntity<List<Track>> showAllTracks() {
        List<Track> track1 = trackService.showAllTrack();
        return new ResponseEntity<List<Track>>(track1, HttpStatus.OK);
    }

    @RequestMapping(value = "trackupdate", method = RequestMethod.PUT)
    public ResponseEntity<String> updateTrack(@RequestBody Track track) throws TrackNotFoundException {
        ResponseEntity responseEntity;
        Track track1 = trackService.updateComment(track);
        return new ResponseEntity<String>("Successfully Updated", HttpStatus.OK);
    }

    @RequestMapping(value = "trackdelete", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteTrack(@RequestBody Track track) throws TrackNotFoundException {
        ResponseEntity responseEntity;
        boolean answer = trackService.deleteTrack(track);
        return new ResponseEntity<String>("Successfully Deleted", HttpStatus.OK);
    }

}
