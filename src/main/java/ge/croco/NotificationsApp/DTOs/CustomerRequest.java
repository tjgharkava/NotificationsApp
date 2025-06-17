package ge.croco.NotificationsApp.DTOs;

import lombok.Data;

import java.util.List;

@Data
public class CustomerRequest {
    private String fullName;
    private String email;
    private String phone;

}
