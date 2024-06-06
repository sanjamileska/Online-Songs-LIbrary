package online_songs.library.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "playlists")
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "Date of creation")
    private LocalDate DateOfCreation;

    private boolean isPrivate;

    @ManyToMany
    @JoinTable(
            name = "playlist_song",
            joinColumns = @JoinColumn(name = "playlist_id"),
            inverseJoinColumns = @JoinColumn(name = "song_id")
    )

    private List<Song> songs;

    public Playlist(Long id, String name, LocalDate dateOfCreation, boolean isPrivate, List<Song> songs) {
        this.id = id;
        this.name = name;
        DateOfCreation = dateOfCreation;
        this.isPrivate = isPrivate;
        this.songs = songs;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfCreation() {
        return DateOfCreation;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfCreation(LocalDate dateOfCreation) {
        DateOfCreation = dateOfCreation;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
