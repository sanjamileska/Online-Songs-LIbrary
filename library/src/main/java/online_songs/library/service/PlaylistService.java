package online_songs.library.service;
import online_songs.library.entity.Playlist;

import java.util.List;

public interface PlaylistService {

        Playlist addPlaylist(Playlist playlist);

        List<Playlist> getAllPlaylistByArtist(Long artistId);

        List<Playlist> getPublicPlaylitWithMaxThreeSongs(Long artistId);

        List<Playlist> getPublicPlaylistWithMaxThreeSongs(Long artistId);

        int getTotalDurationOfPlaylist(Long playlistId);

        Playlist addSongToPlaylist(Long songId, Long playlistId);

        void deletePlaylist(Long playlistId);

         List<Playlist> getPublicPlaylistWithMaxThreeSongs();
}
