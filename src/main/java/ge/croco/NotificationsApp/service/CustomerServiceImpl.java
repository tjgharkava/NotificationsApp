package ge.croco.NotificationsApp.service;

import ge.croco.NotificationsApp.DTOs.CustomerRequest;
import ge.croco.NotificationsApp.DTOs.CustomerResponse;
import ge.croco.NotificationsApp.entity.Customer;
import ge.croco.NotificationsApp.mapper.CustomerMapper;
import ge.croco.NotificationsApp.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public CustomerResponse createCustomer(CustomerRequest request) {
        Customer customer = customerMapper.toEntity(request);
        Customer savedCustomer = customerRepository.save(customer);
        return customerMapper.toResponse(savedCustomer);
    }

    @Override
    public CustomerResponse updateCustomer(Long id, CustomerRequest request) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        customer.setFullName(request.getFullName());
        customer.setEmail(request.getEmail());
        customer.setPhone(request.getPhone());
        Customer saved = customerRepository.save(customer);
        return customerMapper.toResponse(saved);
    }
}
