package AdapterPattern.advanceMediaPlayer;

public class AVIPlayer implements AdvanceMediaPlayer {
    @Override
    public void playAdvanceFormat(AdvanceFormat advanceFormat) {
        System.out.println("Playing using advance media player: "+advanceFormat.getFileToPlay()+", "+advanceFormat.getFormatToPlay()+" in resolution: "+advanceFormat.getResolution());
    }
}
