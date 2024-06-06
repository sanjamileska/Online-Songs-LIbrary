package online_songs.library.repository;

import online_songs.library.entity.Artist;
import online_songs.library.entity.Playlist;
import org.springframework.data.repository.CrudRepository;

import java.util.Arrays;
import java.util.List;

public interface PlaylistRepository extends CrudRepository<Playlist, Long> {
    List<Playlist> findByIsPrivateFalseAndSongsSizeLessThanEqual(int maxSongs);
    List<Playlist> findBySongsArtistOrderBySongsArtistNameAscSongsArtistDateOfBirthAsc(Artist artist);

    Arrays findByStatus(String aPublic);
}
