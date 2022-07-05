package com.song.demo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class SongRepository {

    private List<Song> list = new ArrayList<Song>();

    public List<Song> getAllSongs() {
        return this.list;
    }

    public Song getSongById(Integer id) {
        return this.list.stream()
                .filter(song -> Objects.equals(song.getId(), id))
                .findAny()
                .orElse(null);
    }

    public void addSong(Song s) {
        this.list.add(s);
    }

    public void updateSong(Song s) {
        this.list.stream()
                .filter(song -> Objects.equals(song.getId(), s.getId()))
                .findAny()
                .ifPresent(songFound ->
                        this.list.set(list.indexOf(songFound), s));
    }

    public void removeSong(Song s) {
        this.list.remove(s);
    }
}
