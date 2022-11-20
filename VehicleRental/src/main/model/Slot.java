package main.model;

public class Slot {
    private int slotId;
    private long startTime;
    private long endTime;

    public Slot(int slotId, long startTime, long endTime) {
        this.slotId = slotId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }
}
