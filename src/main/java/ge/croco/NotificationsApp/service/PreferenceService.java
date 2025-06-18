package ge.croco.NotificationsApp.service;

import ge.croco.NotificationsApp.DTOs.PreferenceRequest;
import ge.croco.NotificationsApp.DTOs.PreferenceResponse;

public interface PreferenceService {
    PreferenceResponse getPreferenceByCustomerId(Long customerId);
    void updatePreferences(Long customerId, PreferenceRequest preferenceRequest);
    void savePreferences(Long customerId, PreferenceRequest preferencesRequest);
}
