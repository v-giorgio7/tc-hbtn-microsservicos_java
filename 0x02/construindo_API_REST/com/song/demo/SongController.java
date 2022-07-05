package com.song.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SongController {

    @Autowired // initialized by Spring boot
    private SongRepository songRepository;

    @GetMapping("/welcome")
    public String mensagemBoasVindas() {
        return "Hello World!";
    }

    @GetMapping(path = "/allSongs")
    public List<Song> getAllSongs() {
        return this.songRepository.getAllSongs();
    }

    @GetMapping(path = "/findSong/{id}")
    public Song findSongById(@PathVariable Integer id) {
         return this.songRepository.getSongById(id);
    }

    @PostMapping(path = "/addSong", consumes = "application/json", produces = "application/json")
    public Song addSong(@RequestBody Song song) {
        this.songRepository.addSong(song);

        return song;
    }

    @PutMapping(path = "/updateSong", consumes = "application/json", produces = "application/json")
    public Song updateSong(@RequestBody Song song) {
        if (this.songRepository.getSongById(song.getId()) != null) {
            this.songRepository.updateSong(song);
            System.out.println("Som atualizado com sucesso");
        } else {
            System.out.println("Som não encontrado");
        }

        return song;
    }

    @DeleteMapping(path = "/removeSong", consumes = "application/json", produces = "application/json")
    public void deleteSongById(@RequestBody Song song) {
        if (this.songRepository.getSongById(song.getId()) != null) {
            this.songRepository.removeSong(song);
            System.out.println("Som removido com sucesso");
        } else {
            System.out.println("Som não encontrado");
        }
    }
}
