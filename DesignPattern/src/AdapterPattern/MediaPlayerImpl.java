package AdapterPattern;

import AdapterPattern.mediaFactory.PlayMedia;
import AdapterPattern.mediaFactory.PlayMediaInAdvance;
import AdapterPattern.mediaFactory.PlayMediaInDefault;

public class MediaPlayerImpl implements MediaPlayer {
    PlayMedia playMedia;
    @Override
    public void play(String fileToPlay, String formatToPlay) {
        if(formatToPlay.equals("mp3")) {
            playMedia = new PlayMediaInDefault();
            playMedia.play(fileToPlay, formatToPlay);
        } else {
            playMedia = new PlayMediaInAdvance();
            playMedia.play(fileToPlay, formatToPlay);
        }
    }
}
