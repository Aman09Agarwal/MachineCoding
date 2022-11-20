package AdapterPattern.mediaFactory;

import AdapterPattern.MediaPlayerAdapter;
import AdapterPattern.advanceMediaPlayer.AdvanceFormat;

public class PlayMediaInAdvance implements PlayMedia {
    MediaPlayerAdapter mediaPlayerAdapter;
    public void play(String fileToPlay, String formatToPlay) {
        AdvanceFormat advanceFormat = new AdvanceFormat();
        advanceFormat.setResolution("720p");
        mediaPlayerAdapter = new MediaPlayerAdapter(advanceFormat);
        mediaPlayerAdapter.play(fileToPlay, formatToPlay);
    }
}
