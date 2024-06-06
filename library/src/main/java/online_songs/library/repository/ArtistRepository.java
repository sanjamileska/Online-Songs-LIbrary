package online_songs.library.repository;

import online_songs.library.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
    List<Artist> findByDateOfBirthBeforeAndNationality(LocalDate date, String nationality);
}
