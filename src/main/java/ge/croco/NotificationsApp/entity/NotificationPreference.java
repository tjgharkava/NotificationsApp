package ge.croco.NotificationsApp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "notification_preference")
@Data
public class NotificationPreference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean emailEnabled;
    private boolean smsEnabled;
    private boolean pushEnabled;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
