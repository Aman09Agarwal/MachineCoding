package StrategyPattern.resolution;

public class Resolution720p implements Resolution {
    @Override
    public void resolution() {
        System.out.println("Video running on 720p...");
    }
}
