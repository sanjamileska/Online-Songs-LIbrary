package online_songs.library.service.impl;

import online_songs.library.entity.Artist;
import online_songs.library.entity.Genre;
import online_songs.library.entity.Playlist;
import online_songs.library.entity.Song;
import online_songs.library.repository.ArtistRepository;
import online_songs.library.repository.PlaylistRepository;
import online_songs.library.repository.SongRepository;
import online_songs.library.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SongServiceImpl implements SongService {


    private SongRepository songRepository;
    private ArtistRepository artistRepository;
    private PlaylistRepository playlistRepository;

    public SongServiceImpl(SongRepository songRepository, ArtistRepository artistRepository, PlaylistRepository playlistRepository) {
        this.songRepository = songRepository;
        this.artistRepository = artistRepository;
        this.playlistRepository = playlistRepository;
    }

    @Override
    public List<Song> listAll() {
        return songRepository.findAll();
    }

    @Override
    public Song findById(Long id) {
        return songRepository.findById(id).orElse(null);
    }

    @Override
    public Song create(String title, String duration, String releaseDate, Artist artist, Genre genre) {
        Song song = new Song();
        song.setTitle(title);
        song.setDuration(duration);
        song.setReleaseDate(releaseDate);
        song.setArtist(artist);
        song.setGenre(genre);
        return songRepository.save(song);
    }

    @Override
    public Song addSongToArtist(Long artistID, Song song) {
        Artist artist = artistRepository.findById(artistId).orElseThrow(() -> new RuntimeException("Artist not found"));
        song.setArtist(artist);
        return songRepository.save(song);
    }

    @Override
    public Song addSongToPlaylist(Long playlistID, Song song) {
        Playlist playlist = playlistRepository.findById(playlistId).orElseThrow(() -> new RuntimeException("Playlist not found"));
        playlist.getSongs().add(song);
        playlistRepository.save(playlist);
        return song;
    }

    @Override
    public Song getLongestSongOfArtistByGenre(Long artistID, Genre genre) {
        return songRepository.findByArtistIdAndGenre(artistId, genre).stream()
                .max((s1, s2) -> Integer.compare(s1.getDuration(), s2.getDuration()))
                .orElse(null);
    }

    @Override
    public List<Song> getFirstThreeSongsWithDurationBetweenFiveAndTenMinutes() {
        return songRepository.findAll().stream()
                .filter(song -> song.getDuration() >= 5 && song.getDuration() <= 10)
                .sorted((s1, s2) -> Integer.compare(s2.getDuration(), s1.getDuration()))
                .limit(3)
                .collect(Collectors.toList());
    }
}
