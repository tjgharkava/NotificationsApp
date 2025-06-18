package ge.croco.NotificationsApp.service;

import ge.croco.NotificationsApp.DTOs.NotificationRequest;
import ge.croco.NotificationsApp.DTOs.NotificationResponse;

import java.util.List;

public interface NotificationStatusService {
    NotificationResponse createNotificationStatus(NotificationRequest request);
    List<NotificationResponse> getNotificationStatusesByCustomerId(Long customerId);
    List<NotificationResponse> getAllNotificationStatuses();
}
