package online_songs.library.service.impl;

import online_songs.library.entity.Playlist;
import online_songs.library.entity.Song;
import online_songs.library.exceptions.InvalidPlaylistEcxeption;
import online_songs.library.exceptions.InvalidSongException;
import online_songs.library.repository.ArtistRepository;
import online_songs.library.repository.PlaylistRepository;
import online_songs.library.repository.SongRepository;
import online_songs.library.service.PlaylistService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;



@Service
public class PlaylistServiceImpl implements PlaylistService {

    private final PlaylistRepository playlistRepository;
    private final SongRepository songRepository;
    private final ArtistRepository artistRepository;

    public PlaylistServiceImpl(PlaylistRepository playlistRepository, SongRepository songRepository, ArtistRepository artistRepository) {
        this.playlistRepository = playlistRepository;
        this.songRepository = songRepository;
        this.artistRepository = artistRepository;
    }

    @Override
    public Playlist addPlaylist(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    @Override
    public List<Playlist> getAllPlaylistByArtist(Long artistId) {
        return StreamSupport.stream(playlistRepository.findAll().spliterator(), false)
                .filter(playlist -> playlist.getSongs().stream().anyMatch(song -> song.getArtist().getId().equals(artistId)))
                .sorted((p1, p2) -> {
                    int artistNameComparison = p1.getSongs().get(0).getArtist().getName().compareTo(p2.getSongs().get(0).getArtist().getName());
                    if (artistNameComparison != 0) {
                        return artistNameComparison;
                    } else {
                        return p1.getSongs().get(0).getArtist().getDateOfBirth().compareTo(p2.getSongs().get(0).getArtist().getDateOfBirth());
                    }
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<Playlist> getPublicPlaylistWithMaxThreeSongs(Long artistId) {
        List<Playlist> aPublic = StreamSupport.stream(playlistRepository.findByStatus("public").spliterator(), false)
                .filter(playlist -> playlist.getSongs().size() <= 3)
                .collect(Collectors.toList());
        return aPublic;
    }

    @Override
    public int getTotalDurationOfPlaylist(Long playlistId) {
        return playlistRepository.findById(playlistId).orElseThrow(() -> new InvalidPlaylistEcxeption(playlistId))
                .getSongs().stream().mapToInt(Song::getDuration).sum();
    }

    @Override
    public Playlist addSongToPlaylist(Long songId, Long playlistId) {
        Playlist playlist = playlistRepository.findById(playlistId).orElseThrow(() -> new InvalidPlaylistEcxeption(playlistId));
        Song song = songRepository.findById(songId).orElseThrow(() -> new InvalidSongException());
        playlist.getSongs().add(song);
        return playlistRepository.save(playlist);

    }