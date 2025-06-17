package ge.croco.NotificationsApp.DTOs;

import lombok.Data;

import java.util.List;

@Data
public class CustomerResponse {
    private Long id;
    private String fullName;
    private String email;
    private String phone;
    private List<AddressResponse> addresses;
    private PreferenceResponse notificationPreference;
}
