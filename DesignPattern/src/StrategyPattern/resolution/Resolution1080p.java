package StrategyPattern.resolution;

public class Resolution1080p implements Resolution {
    @Override
    public void resolution() {
        System.out.println("Video running on 1080p...");
    }
}
