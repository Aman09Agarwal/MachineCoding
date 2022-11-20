package AdapterPattern.mediaFactory;

import AdapterPattern.DefaultMediaPlayer;
import AdapterPattern.MediaPlayer;

public class PlayMediaInDefault implements PlayMedia{
    MediaPlayer mediaPlayer;
    public void play(String fileToPlay, String formatToPlay) {
        mediaPlayer = new DefaultMediaPlayer();
        mediaPlayer.play(fileToPlay, formatToPlay);
    }
}
