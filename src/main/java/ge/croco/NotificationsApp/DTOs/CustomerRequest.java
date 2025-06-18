package ge.croco.NotificationsApp.DTOs;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class CustomerRequest {
    private String fullName;
    private String email;
    private String phone;

}
