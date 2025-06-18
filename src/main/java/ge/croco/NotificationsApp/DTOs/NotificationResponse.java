package ge.croco.NotificationsApp.DTOs;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NotificationResponse {
    private Long id;
    private Long customerId;
    private String channel;
    private String status;
    private LocalDateTime timeStamp;
}
