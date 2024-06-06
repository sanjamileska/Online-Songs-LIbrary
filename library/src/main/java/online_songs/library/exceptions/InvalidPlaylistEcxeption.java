package online_songs.library.exceptions;

public class InvalidPlaylistEcxeption extends RuntimeException{
    public InvalidPlaylistEcxeption(Long playlist) {
        super(String.format("Invalid playlist!", playlist));
    }


}
