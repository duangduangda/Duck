package org.dean.duck.fp;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.Collections.unmodifiableList;
import static java.util.stream.Collectors.toList;

/**
 * @description:
 * @author: dean
 * @create: 2019/04/22 17:23
 */
public class Albulumn {

    private String name;
    private List<Track> tracks;
    private List<Artist> musicians;

    public Albulumn(String name, List<Track> tracks, List<Artist> musicians) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(tracks);
        Objects.requireNonNull(musicians);

        this.name = name;
        this.tracks = new ArrayList<>(tracks);
        this.musicians = new ArrayList<>(musicians);
    }


    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the tracks
     */
    public Stream<Track> getTracks() {
        return tracks.stream();
    }

    /**
     * Used in imperative code examples that need to iterate over a list
     */
    public List<Track> getTrackList() {
        return unmodifiableList(tracks);
    }

    /**
     * @return the musicians
     */
    public Stream<Artist> getMusicians() {
        return musicians.stream();
    }

    /**
     * Used in imperative code examples that need to iterate over a list
     */
    public List<Artist> getMusicianList() {
        return unmodifiableList(musicians);
    }

    public Artist getMainMusician() {
        return musicians.get(0);
    }

    public Albulumn copy() {
        List<Track> tracks = getTracks().map(Track::copy).collect(toList());
        List<Artist> musicians = getMusicians().map(Artist::copy).collect(toList());
        return new Albulumn(name, tracks, musicians);
    }

}
