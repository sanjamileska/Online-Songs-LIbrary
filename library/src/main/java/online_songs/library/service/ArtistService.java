package online_songs.library.service;

import online_songs.library.entity.Artist;
import online_songs.library.entity.Song;

import java.util.List;
import java.util.Optional;

public interface ArtistService {

    Artist addArtist(Artist artist);

    List<Artist> getAllArtistsBornBefore1999AndMacedonian();

    Optional<Artist> getArtistDetails(Long artistId);


    Song addSongToArtist(Long id, Song song);

    Song getLongestSongOfArtistByGenre(Long id, String genre);
}
