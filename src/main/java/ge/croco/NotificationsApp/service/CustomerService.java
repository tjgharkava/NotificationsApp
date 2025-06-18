package ge.croco.NotificationsApp.service;

import ge.croco.NotificationsApp.DTOs.CustomerRequest;
import ge.croco.NotificationsApp.DTOs.CustomerResponse;

import java.util.List;

public interface CustomerService {
    CustomerResponse createCustomer(CustomerRequest request);
    CustomerResponse updateCustomer(Long id, CustomerRequest request);
    void deleteCustomer(Long id);
    List<CustomerResponse> getAllCustomers();
    CustomerResponse getCustomerById(Long id);
    Long addCustomer(CustomerRequest request);
}
