package ge.croco.NotificationsApp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "notification_status")
@Data
public class NotificationStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String channel;
    private String status;
    private LocalDateTime timeStamp;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
