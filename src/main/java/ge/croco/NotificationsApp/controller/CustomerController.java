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

    @GetMapping
    public String getCustomers(Model model) {
        List<CustomerResponse> customers = customerService.getAllCustomers();
        model.addAttribute("customers", customers);
        return "customers/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("customerRequest", new CustomerRequest());
        return "customers/create";
    }

    @GetMapping("/{id}/edit")
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
    public String createCustomer(@ModelAttribute CustomerRequest request) {
        customerService.createCustomer(request);
        return "redirect:/customers";
    }

    @PostMapping("/{id}")
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
