package ge.croco.NotificationsApp.repository;

import ge.croco.NotificationsApp.entity.NotificationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationStatusRepository extends JpaRepository<NotificationStatus, Long> {
    List<NotificationStatus> findByCustomerId(Long customerId);
}
