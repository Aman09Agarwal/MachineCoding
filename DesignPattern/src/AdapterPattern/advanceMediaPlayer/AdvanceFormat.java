package AdapterPattern.advanceMediaPlayer;

public class AdvanceFormat {
    private String fileToPlay;
    private String formatToPlay;
    private String resolution;

    public AdvanceFormat() {
    }

    public AdvanceFormat(String fileToPlay, String formatToPlay, String resolution) {
        this.fileToPlay = fileToPlay;
        this.formatToPlay = formatToPlay;
        this.resolution = resolution;
    }

    public String getFileToPlay() {
        return fileToPlay;
    }

    public void setFileToPlay(String fileToPlay) {
        this.fileToPlay = fileToPlay;
    }

    public String getFormatToPlay() {
        return formatToPlay;
    }

    public void setFormatToPlay(String formatToPlay) {
        this.formatToPlay = formatToPlay;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }
}
