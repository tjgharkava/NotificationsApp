package ge.croco.NotificationsApp.service;

import ge.croco.NotificationsApp.DTOs.NotificationRequest;
import ge.croco.NotificationsApp.DTOs.NotificationResponse;
import ge.croco.NotificationsApp.entity.Customer;
import ge.croco.NotificationsApp.entity.NotificationStatus;
import ge.croco.NotificationsApp.repository.CustomerRepository;
import ge.croco.NotificationsApp.repository.NotificationStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationStatusServiceImpl implements NotificationStatusService {

    private final NotificationStatusRepository repository;
    private final CustomerRepository customerRepository;

    @Override
    public NotificationResponse createNotificationStatus(NotificationRequest request) {
        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        NotificationStatus status = new NotificationStatus();
        status.setCustomer(customer);
        status.setChannel(request.getChannel());
        status.setStatus(request.getStatus());
        status.setTimeStamp(request.getTimeStamp() != null ? request.getTimeStamp() : LocalDateTime.now());

        NotificationStatus saved = repository.save(status);
        return mapToResponse(saved);
    }

    @Override
    public List<NotificationResponse> getNotificationStatusesByCustomerId(Long customerId) {
        List<NotificationStatus> statuses = repository.findByCustomerId(customerId);
        return statuses.stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public List<NotificationResponse> getAllNotificationStatuses() {
        return repository.findAll().stream()
                .map(this::mapToResponse)
                .toList();
    }

    private NotificationResponse mapToResponse(NotificationStatus status) {
        NotificationResponse response = new NotificationResponse();
        response.setId(status.getId());
        response.setCustomerId(status.getCustomer().getId());
        response.setChannel(status.getChannel());
        response.setStatus(status.getStatus());
        response.setTimeStamp(status.getTimeStamp());
        return response;
    }
}
