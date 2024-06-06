package online_songs.library.service;


import online_songs.library.entity.Artist;
import online_songs.library.entity.Genre;
import online_songs.library.entity.Song;

import java.util.List;

public interface SongService {

    List<Song> listAll();

    Song findById(Long id);

    Song create(String title, String duration, String releaseDate, Artist artist, Genre genre);

    Song addSongToArtist(Long artistID, Song song);

    Song addSongToPlaylist(Long playlistID, Song song);

    Song getLongestSongOfArtistByGenre(Long artistID, Genre genre);

    List<Song> getFirstThreeSongsWithDurationBetweenFiveAndTenMinutes();

}
