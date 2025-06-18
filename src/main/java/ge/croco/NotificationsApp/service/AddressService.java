package ge.croco.NotificationsApp.service;

import ge.croco.NotificationsApp.DTOs.AddressRequest;
import ge.croco.NotificationsApp.DTOs.AddressResponse;

import java.util.List;

public interface AddressService {
    List<AddressResponse> getAddressesByCustomerId(Long customerId);
    void addAddress(Long customerId, AddressRequest request);
    void updateAddress(Long addressId, AddressRequest request);
    void deleteAddress(Long addressId);
    AddressResponse getAddressById(Long addressId);
}
