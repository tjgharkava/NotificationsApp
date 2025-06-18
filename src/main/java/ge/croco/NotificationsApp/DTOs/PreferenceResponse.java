package ge.croco.NotificationsApp.DTOs;

import lombok.Data;

@Data
public class PreferenceResponse {
    private Long id;
    private boolean emailEnabled;
    private boolean smsEnabled;
    private boolean pushEnabled;
}
