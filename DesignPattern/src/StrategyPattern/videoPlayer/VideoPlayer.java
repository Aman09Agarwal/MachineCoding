package StrategyPattern.videoPlayer;

import StrategyPattern.device.Device;
import StrategyPattern.resolution.Resolution;

public abstract class VideoPlayer {
    Device device;
    Resolution resolution;

    public void getDevice() {
        device.device();
    }

    public void getResolution() {
        resolution.resolution();
    }

    public abstract void display();
}
