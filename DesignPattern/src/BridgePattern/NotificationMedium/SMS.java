package BridgePattern.NotificationMedium;

public class SMS implements NotificationSender {
    @Override
    public void sendNotification() {
        System.out.println("Sending SMS...");
    }
}
