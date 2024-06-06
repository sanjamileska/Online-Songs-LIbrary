package online_songs.library.service.impl;

import online_songs.library.entity.Artist;
import online_songs.library.entity.Song;
import online_songs.library.repository.ArtistRepository;
import online_songs.library.service.ArtistService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepository;

    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public Artist addArtist(Artist artist) {
        return artistRepository.save(artist);
    }

    @Override
    public List<Artist> getAllArtistsBornBefore1999AndMacedonian() {
        return List.of();
    }


    @Override
    public Optional<Artist> getArtistDetails(Long artistId) {
        return artistRepository.findById(artistId);
    }

    @Override
    public Song addSongToArtist(Long id, Song song) {
        return null;
    }

    @Override
    public Song getLongestSongOfArtistByGenre(Long id, String genre) {
        return null;
    }
}
