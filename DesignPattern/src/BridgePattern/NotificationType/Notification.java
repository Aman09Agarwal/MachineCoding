package BridgePattern.NotificationType;

import BridgePattern.NotificationMedium.NotificationSender;

public abstract class Notification {
    NotificationSender notificationSender;

    public Notification(NotificationSender notificationSender) {
        this.notificationSender = notificationSender;
    }

    abstract public void sendMessage();
}
