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
@Table(name = "artist")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "artistic name")
    private String artisticName;

    @Column(name = "Date of Birth")
    private LocalDate dateOfBirth;

    @Column(name = "nationality")
    private String nationality;


    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL)
    private List<Song> songs;

    public Artist(Long id, String name, String artisticName, String dateOfBirth, String nationality, List<Song> songs) {
        this.id = id;
        this.name = name;
        this.artisticName = artisticName;
        this.dateOfBirth = LocalDate.parse(dateOfBirth);
        this.nationality = nationality;
        this.songs = songs;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getArtisticName() {
        return artisticName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getNationality() {
        return nationality;
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

    public void setArtisticName(String artisticName) {
        this.artisticName = artisticName;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = LocalDate.parse(dateOfBirth);
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
