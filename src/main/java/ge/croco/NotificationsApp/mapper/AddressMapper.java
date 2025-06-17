package ge.croco.NotificationsApp.mapper;

import ge.croco.NotificationsApp.DTOs.AddressRequest;
import ge.croco.NotificationsApp.DTOs.AddressResponse;
import ge.croco.NotificationsApp.entity.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {
    public Address toEntity(AddressRequest request) {
        Address address = new Address();
        address.setType(request.getType());
        address.setValue(request.getValue());
        return address;
    }

    public AddressResponse toResponse(Address address) {
        AddressResponse response = new AddressResponse();
        response.setId(address.getId());
        response.setType(address.getType());
        response.setValue(address.getValue());
        return response;
    }
}
