package ge.croco.NotificationsApp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "notification_preference")
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
