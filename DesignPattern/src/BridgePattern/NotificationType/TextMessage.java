package BridgePattern.NotificationType;

import BridgePattern.NotificationMedium.NotificationSender;

public class TextMessage extends Notification {

    public TextMessage(NotificationSender notificationSender) {
        super(notificationSender);
        System.out.println("This is a text message...");
    }

    public void sendMessage() {
        notificationSender.sendNotification();
    }
}
