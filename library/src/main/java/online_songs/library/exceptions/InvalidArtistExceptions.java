package online_songs.library.exceptions;

public class InvalidArtistExceptions extends RuntimeException{
    public InvalidArtistExceptions(String artist) {
        super(String.format("Invalid artist!" , artist));
    }
}
