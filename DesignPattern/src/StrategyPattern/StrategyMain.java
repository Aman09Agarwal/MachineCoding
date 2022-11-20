package StrategyPattern;

import StrategyPattern.device.Device;
import StrategyPattern.device.Phone;
import StrategyPattern.resolution.Resolution;
import StrategyPattern.resolution.Resolution1080p;
import StrategyPattern.videoPlayer.PhoneVideoPlayer;
import StrategyPattern.videoPlayer.VideoPlayer;

public class StrategyMain {
    public static void main(String[] args) {
        Device device = new Phone();
        Resolution resolution = new Resolution1080p();
        VideoPlayer phonePlayer = new PhoneVideoPlayer(device, resolution);
        phonePlayer.display();
    }
}
