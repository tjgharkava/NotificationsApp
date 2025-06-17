package ge.croco.NotificationsApp.service;

import ge.croco.NotificationsApp.entity.AppUser;
import ge.croco.NotificationsApp.entity.Role;
import ge.croco.NotificationsApp.repository.AppUserRepository;
import ge.croco.NotificationsApp.repository.RoleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class AppUserService {
    private final AppUserRepository appUserRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public void registerAdmin(AppUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        Role admin = roleRepository.findByName("ROLE_ADMIN")
                .orElseGet(() -> {
                    System.out.println("Creating ROLE_ADMIN...");
                    Role role = new Role();
                    role.setName("ROLE_ADMIN");
                    return roleRepository.save(role);
                });
        user.getRoles().add(admin);
        appUserRepository.save(user);
    }
}
