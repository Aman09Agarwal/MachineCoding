package AdapterPattern;

import AdapterPattern.advanceMediaPlayer.AVIPlayer;
import AdapterPattern.advanceMediaPlayer.AdvanceFormat;
import AdapterPattern.advanceMediaPlayer.AdvanceMediaPlayer;

public class MediaPlayerAdapter implements MediaPlayer {
    AdvanceFormat advanceFormat;
    AdvanceMediaPlayer advanceMediaPlayer;

    public MediaPlayerAdapter(AdvanceFormat advanceFormat) {
        this.advanceFormat = advanceFormat;
        advanceMediaPlayer = new AVIPlayer();
    }

    public void play(String fileToPlay, String formatToPlay) {
        advanceFormat.setFileToPlay(fileToPlay);
        advanceFormat.setFormatToPlay(formatToPlay);
        advanceMediaPlayer.playAdvanceFormat(advanceFormat);
    }
}
