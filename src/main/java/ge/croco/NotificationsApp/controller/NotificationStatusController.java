package ge.croco.NotificationsApp.controller;

import ge.croco.NotificationsApp.DTOs.NotificationResponse;
import ge.croco.NotificationsApp.service.NotificationStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("notification-status")
@RequiredArgsConstructor
public class NotificationStatusController {

    private final NotificationStatusService notificationStatusService;

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<NotificationResponse>> getByCustomer(@PathVariable Long customerId) {
        List<NotificationResponse> list = notificationStatusService.getNotificationStatusesByCustomerId(customerId);
        return ResponseEntity.ok(list);
    }

    @GetMapping
    public ResponseEntity<List<NotificationResponse>> getAll() {
        List<NotificationResponse> list = notificationStatusService.getAllNotificationStatuses();
        return ResponseEntity.ok(list);
    }
}
