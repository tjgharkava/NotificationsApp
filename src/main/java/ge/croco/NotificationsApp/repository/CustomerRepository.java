package ge.croco.NotificationsApp.repository;

import ge.croco.NotificationsApp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    List<Customer> findByFullNameContainingIgnoreCase(String lastName);
}
