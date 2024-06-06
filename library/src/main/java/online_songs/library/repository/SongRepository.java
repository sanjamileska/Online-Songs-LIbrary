package online_songs.library.repository;

import online_songs.library.entity.Artist;
import online_songs.library.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SongRepository extends JpaRepository<Song, Long> {
    List<Song> findByDurationBetweenOrderByDurationDesc(int min, int max);
    Optional<Song> findFirstByArtistAndGenreOrderByDurationDesc(Artist artist, String genre);
}
