package online_songs.library.exceptions;

public class InvalidSongException extends RuntimeException{
    public InvalidSongException(){
        super(String.format("Invalid song: %s", song));
    }
}
