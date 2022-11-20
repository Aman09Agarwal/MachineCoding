package StrategyPattern.videoPlayer;

import StrategyPattern.device.Device;
import StrategyPattern.resolution.Resolution;

public class TVVideoPlayer extends VideoPlayer {
    public TVVideoPlayer(Device device, Resolution resolution) {
        this.device = device;
        this.resolution = resolution;
    }

    public void display() {
        this.getDevice();
        this.getResolution();
    }
}
