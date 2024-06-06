package online_songs.library.controller;


import online_songs.library.entity.Artist;
import online_songs.library.entity.Song;
import online_songs.library.service.ArtistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/artists")
public class ArtistController {


    private ArtistService artistService;

    @PostMapping
    public ResponseEntity<Artist> addArtist(@RequestBody Artist artist) {
        return ResponseEntity.ok(artistService.addArtist(artist));
    }

    @GetMapping("/before-1999/macedonian")
    public ResponseEntity<List<Artist>> getAllArtistsBornBefore1999AndMacedonian() {
        return ResponseEntity.ok(artistService.getAllArtistsBornBefore1999AndMacedonian());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Artist> getArtistDetails(@PathVariable Long id) {
        return ResponseEntity.ok(artistService.getArtistDetails(id));
    }

    @PostMapping("/{id}/songs")
    public ResponseEntity<Song> addSongToArtist(@PathVariable Long id, @RequestBody Song song) {
        return ResponseEntity.ok(artistService.addSongToArtist(id, song));
    }

    @GetMapping("/{id}/longest-song/{genre}")
    public ResponseEntity<Song> getLongestSongOfArtistByGenre(@PathVariable Long id, @PathVariable String genre) {
        return ResponseEntity.ok(artistService.getLongestSongOfArtistByGenre(id, genre));
    }
}
