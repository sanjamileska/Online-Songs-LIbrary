package online_songs.library.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "songs")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "duration")
    private String duration;

    @Column(name = "releaseDate")
    private String releaseDate;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Artist artist;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    public Song(Long id, String title, String duration, String releaseDate, Artist artist, Genre genre) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.releaseDate = releaseDate;
        this.artist = artist;
        this.genre = genre;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public Genre getGenre() {
        return genre;
    }

    public Artist getArtist() {
        return artist;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getDuration() {
        return duration;
    }

    public String getTitle() {
        return title;
    }


}
