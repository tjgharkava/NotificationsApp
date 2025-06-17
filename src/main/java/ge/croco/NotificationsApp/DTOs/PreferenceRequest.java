package ge.croco.NotificationsApp.DTOs;

import lombok.Data;

@Data
public class PreferenceRequest {
    private boolean emailEnabled;
    private boolean smsEnabled;
    private boolean pushEnabled;
}
