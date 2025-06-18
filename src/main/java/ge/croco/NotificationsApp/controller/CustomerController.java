package ge.croco.NotificationsApp.controller;

import ge.croco.NotificationsApp.DTOs.CustomerRequest;
import ge.croco.NotificationsApp.DTOs.CustomerResponse;
import ge.croco.NotificationsApp.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("customerRequest", new CustomerRequest());
        return "customers/register";
    }

    @PostMapping("/register")
    public String registerCustomer(@ModelAttribute CustomerRequest request) {
        Long customerId = customerService.addCustomer(request);
        return "redirect:/customers/" + customerId + "/addresses/new";
    }

    @GetMapping
    // URL: localhost:8080/customers
    public String getCustomers(Model model) {
        List<CustomerResponse> customers = customerService.getAllCustomers();
        model.addAttribute("customers", customers);
        return "customers/list";
    }

    @GetMapping("/new")
    // URL: localhost:8080/customers/new
    public String showCreateForm(Model model) {
        model.addAttribute("customerRequest", new CustomerRequest());
        return "customers/create";
    }

    @GetMapping("/{id}/edit")
    // URL: localhost:8080/customers/1/edit
    public String showEditForm(@PathVariable Long id, Model model) {
        CustomerResponse customer = customerService.getCustomerById(id);
        CustomerRequest request = new CustomerRequest();
        request.setFullName(customer.getFullName());
        request.setEmail(customer.getEmail());
        request.setPhone(customer.getPhone());

        model.addAttribute("customerRequest", request);
        model.addAttribute("customerId", id);
        return "customers/edit";
    }

    @PostMapping
    // URL: localhost:8080/customers
    public String createCustomer(@ModelAttribute CustomerRequest request) {
        customerService.createCustomer(request);
        return "redirect:/customers";
    }

    @PostMapping("/{id}/edit")
    // URL: http://localhost:8080/customers/1/edit
    public String updateCustomer(@PathVariable Long id, @ModelAttribute CustomerRequest customerRequest) {
        customerService.updateCustomer(id, customerRequest);
        return "redirect:/customers";
    }

    @PostMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return "redirect:/customers";
    }
}
