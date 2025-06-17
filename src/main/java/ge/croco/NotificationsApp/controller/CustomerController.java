package ge.croco.NotificationsApp.controller;

import ge.croco.NotificationsApp.DTOs.CustomerRequest;
import ge.croco.NotificationsApp.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public String createCustomer(@ModelAttribute CustomerRequest request) {
        customerService.createCustomer(request);
        return "redirect:/customers";
    }
}
