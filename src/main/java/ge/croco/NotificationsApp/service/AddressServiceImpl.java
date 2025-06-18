package ge.croco.NotificationsApp.service;

import ge.croco.NotificationsApp.DTOs.AddressRequest;
import ge.croco.NotificationsApp.DTOs.AddressResponse;
import ge.croco.NotificationsApp.entity.Address;
import ge.croco.NotificationsApp.entity.Customer;
import ge.croco.NotificationsApp.mapper.AddressMapper;
import ge.croco.NotificationsApp.repository.AddressRepository;
import ge.croco.NotificationsApp.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final CustomerService customerService;
    private final AddressMapper addressMapper;
    private final CustomerRepository customerRepository;


    @Override
    public List<AddressResponse> getAddressesByCustomerId(Long customerId) {
        return addressRepository.findByCustomerId(customerId).stream()
                .map(addressMapper::toResponse)
                .toList();
    }

    @Override
    public void addAddress(Long customerId, AddressRequest request) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        Address address = addressMapper.toEntity(request);
        address.setCustomer(customer);
        addressRepository.save(address);
    }

    @Override
    public void updateAddress(Long addressId, AddressRequest request) {
        Address address = addressRepository.findById(addressId)
                .orElseThrow(() -> new RuntimeException("Address not found"));
        address.setType(request.getType());
        address.setValue(request.getValue());
        addressRepository.save(address);
    }

    @Override
    public void deleteAddress(Long addressId) {
        addressRepository.deleteById(addressId);
    }

    @Override
    public AddressResponse getAddressById(Long addressId) {
        Address address = addressRepository.findById(addressId)
                .orElseThrow(() -> new RuntimeException("Address not found"));
        return addressMapper.toResponse(address);
    }
}
