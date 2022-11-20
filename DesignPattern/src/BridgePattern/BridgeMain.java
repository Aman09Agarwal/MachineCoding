package BridgePattern;

import BridgePattern.NotificationMedium.SMS;
import BridgePattern.NotificationType.Notification;
import BridgePattern.NotificationType.QRCode;

public class BridgeMain {
    public static void main(String[] args) {
        Notification notification = new QRCode(new SMS());
        notification.sendMessage();
    }
}
