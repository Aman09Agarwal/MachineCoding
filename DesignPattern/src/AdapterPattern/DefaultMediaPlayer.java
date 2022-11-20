package AdapterPattern;

public class DefaultMediaPlayer implements MediaPlayer {
    public void play(String fileToPlay, String formatToPlay) {
        System.out.println("Playing "+fileToPlay+", "+formatToPlay);
    }
}
