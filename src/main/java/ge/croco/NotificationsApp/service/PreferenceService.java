package ge.croco.NotificationsApp.service;

import ge.croco.NotificationsApp.DTOs.PreferenceRequest;
import ge.croco.NotificationsApp.DTOs.PreferenceResponse;

public interface PreferenceService {
    PreferenceResponse getPreferenceByCustomerId(Long customerId);
    PreferenceResponse updatePreferences(Long customerId, PreferenceRequest preferenceRequest);
}
