package ge.croco.NotificationsApp.mapper;

import ge.croco.NotificationsApp.DTOs.PreferenceRequest;
import ge.croco.NotificationsApp.DTOs.PreferenceResponse;
import ge.croco.NotificationsApp.entity.NotificationPreference;
import org.springframework.stereotype.Component;

@Component
public class PreferenceMapper {
    public NotificationPreference toEntity(PreferenceRequest request) {
        NotificationPreference pref = new NotificationPreference();
        pref.setEmailEnabled(request.isEmailEnabled());
        pref.setSmsEnabled(request.isSmsEnabled());
        pref.setPushEnabled(request.isPushEnabled());
        return pref;
    }

    public PreferenceResponse toResponse(NotificationPreference pref) {
        PreferenceResponse response = new PreferenceResponse();
        response.setEmailEnabled(pref.isEmailEnabled());
        response.setSmsEnabled(pref.isSmsEnabled());
        response.setPushEnabled(pref.isPushEnabled());
        return response;
    }
}
