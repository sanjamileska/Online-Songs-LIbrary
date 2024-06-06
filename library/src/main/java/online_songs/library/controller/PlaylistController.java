package online_songs.library.controller;


import online_songs.library.entity.Playlist;
import online_songs.library.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/playlists")
public class PlaylistController {


    private PlaylistService playlistService;

    @PostMapping
    public ResponseEntity<Playlist> addPlaylist(@RequestBody Playlist playlist) {
        return ResponseEntity.ok(playlistService.addPlaylist(playlist));
    }

    @GetMapping("/by-artist/{artistId}")
    public ResponseEntity<List<Playlist>> getAllPlaylistsByArtist(@PathVariable Long artistId) {
        return ResponseEntity.ok(playlistService.getAllPlaylistByArtist(artistId));
    }

    @GetMapping("/public-with-max-three-songs")
    public ResponseEntity<List<Playlist>> getPublicPlaylistsWithMaxThreeSongs() {
        return ResponseEntity.ok(playlistService.getPublicPlaylistWithMaxThreeSongs());
    }

    @GetMapping("/{id}/total-duration")
    public ResponseEntity<Integer> getTotalDurationOfPlaylist(@PathVariable Long id) {
        return ResponseEntity.ok(playlistService.getTotalDurationOfPlaylist(id));
    }

    @PostMapping("/{playlistId}/songs/{songId}")
    public ResponseEntity<Playlist> addSongToPlaylist(@PathVariable Long playlistId, @PathVariable Long songId) {
        return ResponseEntity.ok(playlistService.addSongToPlaylist(playlistId, songId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlaylist(@PathVariable Long id) {
        playlistService.deletePlaylist(id);
        return ResponseEntity.noContent().build();
    }
}
