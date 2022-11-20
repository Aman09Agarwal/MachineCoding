package StrategyPattern.videoPlayer;

import StrategyPattern.device.Device;
import StrategyPattern.resolution.Resolution;

public class PhoneVideoPlayer extends VideoPlayer {
    public PhoneVideoPlayer(Device device, Resolution resolution) {
        this.device = device;
        this.resolution = resolution;
    }

    public void display() {
        this.getDevice();
        this.getResolution();
    }
}
