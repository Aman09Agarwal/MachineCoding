package BridgePattern.NotificationType;

import BridgePattern.NotificationMedium.NotificationSender;

public class QRCode extends Notification {

    public QRCode(NotificationSender notificationSender) {
        super(notificationSender);
        System.out.println("This is a QR code...");
    }

    public void sendMessage() {
        notificationSender.sendNotification();
    }
}
