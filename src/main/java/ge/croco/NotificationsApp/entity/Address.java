package ge.croco.NotificationsApp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "addresses")
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String value;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
