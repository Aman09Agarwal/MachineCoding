package AdapterPattern;

public class AdapterMain {
    public static void main(String[] args) {
        MediaPlayer mediaPlayer = new MediaPlayerImpl();
        mediaPlayer.play("my song", "mp3");
        mediaPlayer.play("my song in advance format", "avi");
    }
}
