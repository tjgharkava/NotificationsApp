package ge.croco.NotificationsApp.mapper;

import ge.croco.NotificationsApp.DTOs.CustomerRequest;
import ge.croco.NotificationsApp.DTOs.CustomerResponse;
import ge.croco.NotificationsApp.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    private final AddressMapper addressMapper;
    private final PreferenceMapper preferenceMapper;

    public CustomerMapper(AddressMapper addressMapper, PreferenceMapper preferenceMapper) {
        this.addressMapper = addressMapper;
        this.preferenceMapper = preferenceMapper;
    }

    public Customer toEntity(CustomerRequest request) {
        Customer customer = new Customer();
        customer.setFullName(request.getFullName());
        customer.setEmail(request.getEmail());
        customer.setPhone(request.getPhone());
        return customer;
    }

    public CustomerResponse toResponse(Customer customer) {
        CustomerResponse response = new CustomerResponse();
        response.setId(customer.getId());
        response.setFullName(customer.getFullName());
        response.setEmail(customer.getEmail());
        response.setPhone(customer.getPhone());

        response.setAddresses(customer.getAddresses().stream()
                .map(addressMapper::toResponse)
                .toList());

        if (customer.getPreference() != null) {
            response.setNotificationPreference(preferenceMapper.toResponse(customer.getPreference()));
        }

        return response;
    }
}
