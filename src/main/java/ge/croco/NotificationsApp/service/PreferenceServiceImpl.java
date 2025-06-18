package ge.croco.NotificationsApp.service;

import ge.croco.NotificationsApp.DTOs.PreferenceRequest;
import ge.croco.NotificationsApp.DTOs.PreferenceResponse;
import ge.croco.NotificationsApp.entity.NotificationPreference;
import ge.croco.NotificationsApp.repository.CustomerRepository;
import ge.croco.NotificationsApp.repository.PreferenceRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Not;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PreferenceServiceImpl implements PreferenceService {

    private final PreferenceRepository preferenceRepository;
    private final CustomerRepository customerRepository;


    @Override
    public PreferenceResponse getPreferenceByCustomerId(Long customerId) {
        NotificationPreference preference = preferenceRepository.findByCustomerId(customerId)
                .orElseGet(() -> {
                    NotificationPreference newPreference = new NotificationPreference();
                    newPreference.setCustomer(customerRepository.findById(customerId)
                            .orElseThrow(() -> new RuntimeException("Customer not found")));
                    newPreference.setEmailEnabled(false);
                    newPreference.setSmsEnabled(false);
                    newPreference.setPushEnabled(false);
                    return preferenceRepository.save(newPreference);
                });

        return mapToResponse(preference);
    }

    @Override
    public PreferenceResponse updatePreferences(Long customerId, PreferenceRequest preferenceRequest) {
        NotificationPreference preference = preferenceRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        preference.setEmailEnabled(preferenceRequest.isEmailEnabled());
        preference.setSmsEnabled(preferenceRequest.isSmsEnabled());
        preference.setPushEnabled(preferenceRequest.isPushEnabled());

        NotificationPreference updatedPreference = preferenceRepository.save(preference);
        return mapToResponse(updatedPreference);
    }

    private PreferenceResponse mapToResponse(NotificationPreference pref) {
        PreferenceResponse response = new PreferenceResponse();
        response.setId(pref.getId());
        response.setEmailEnabled(pref.isEmailEnabled());
        response.setSmsEnabled(pref.isSmsEnabled());
        response.setPushEnabled(pref.isPushEnabled());
        return response;
    }
}
