package online_songs.library.controller;


import online_songs.library.entity.Song;
import online_songs.library.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/songs")
public class SongController {

    @Autowired
    private SongService songService;

    @GetMapping
    public ResponseEntity<List<Song>> listAllSongs() {
        return ResponseEntity.ok(songService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Song> getSongById(@PathVariable Long id) {
        return ResponseEntity.ok(songService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Song> createSong(@RequestBody Song song) {
        return ResponseEntity.ok(songService.create(song.getTitle(), song.getDuration(), song.getReleaseDate(), song.getArtist(), song.getGenre()));
    }

    @GetMapping("/first-three-songs")
    public ResponseEntity<List<Song>> getFirstThreeSongsWithDurationBetweenFiveAndTenMinutes() {
        return ResponseEntity.ok(songService.getFirstThreeSongsWithDurationBetweenFiveAndTenMinutes());
    }
}
