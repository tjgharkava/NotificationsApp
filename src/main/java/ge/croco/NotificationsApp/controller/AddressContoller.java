package ge.croco.NotificationsApp.controller;

import ge.croco.NotificationsApp.DTOs.AddressRequest;
import ge.croco.NotificationsApp.DTOs.AddressResponse;
import ge.croco.NotificationsApp.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customers/{customerId}/addresses")
@RequiredArgsConstructor
public class AddressContoller {
    private final AddressService addressService;

    @GetMapping
    public String listAddresses(@PathVariable Long customerId, Model model) {
        model.addAttribute("addresses", addressService.getAddressesByCustomerId(customerId));
        model.addAttribute("customerId", customerId);
        return "addresses/list";
    }

    @GetMapping("/new")
    public String addForm(@PathVariable Long customerId, Model model) {
        model.addAttribute("addressRequest", new AddressRequest());
        model.addAttribute("customerId", customerId);
        return "address/add";
    }

    @PostMapping
    public String addAddress(@PathVariable Long customerId, @ModelAttribute AddressRequest addressRequest) {
        addressService.addAddress(customerId, addressRequest);
        return "redirect:/customers/" + customerId + "/addresses";
    }

    @PostMapping("/{addressId}/delete")
    public String deleteAddress(@PathVariable Long customerId,
                                @PathVariable Long addressId) {
        addressService.deleteAddress(addressId);
        return "redirect:/customers/" + customerId + "/addresses";
    }

    @GetMapping("/{addressId}/edit")
    public String editForm(@PathVariable Long customerId,@PathVariable Long addressId, Model model) {
        AddressResponse address = addressService.getAddressById(addressId);
        AddressRequest request = new AddressRequest();
        request.setType(address.getType());
        request.setValue(address.getValue());

        model.addAttribute("addressRequest", request);
        model.addAttribute("customerId", customerId);
        model.addAttribute("addressId", addressId);
        return "address/edit";
    }
}
