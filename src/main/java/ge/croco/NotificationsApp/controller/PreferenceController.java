package ge.croco.NotificationsApp.controller;

import ge.croco.NotificationsApp.DTOs.PreferenceRequest;
import ge.croco.NotificationsApp.DTOs.PreferenceResponse;
import ge.croco.NotificationsApp.service.PreferenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customers/{customerId}/preferences")
@RequiredArgsConstructor
public class PreferenceController {

    private final PreferenceService preferenceService;

    @GetMapping("/edit")
    public String showPreferencesForm(@PathVariable Long customerId, Model model) {
        model.addAttribute("preferencesRequest", new PreferenceRequest()); // or load from DB
        model.addAttribute("customerId", customerId);
        return "preferences/edit";
    }

    @PostMapping
    public String savePreferences(@PathVariable Long customerId,
                                  @ModelAttribute PreferenceRequest preferencesRequest) {
        preferenceService.savePreferences(customerId, preferencesRequest);
        return "redirect:/customers";
    }
}
