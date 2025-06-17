package ge.croco.NotificationsApp.user.service;


import ge.croco.NotificationsApp.user.entity.AppUser;
import ge.croco.NotificationsApp.user.entity.Role;
import ge.croco.NotificationsApp.user.repository.AppUserRepository;
import ge.croco.NotificationsApp.user.repository.RoleRepository;
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

    public void registerUser(AppUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);

        Role userRole = roleRepository.findByName("ROLE_USER")
                .orElseGet(() -> {
                    ge.croco.NotificationsApp.user.entity.Role role = new ge.croco.NotificationsApp.user.entity.Role();
                    role.setName("ROLE_USER");
                    return roleRepository.save(role);
                });

        user.getRoles().add(userRole);
        appUserRepository.save(user);
    }

    public void registerAdmin(AppUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        ge.croco.NotificationsApp.user.entity.Role admin = roleRepository.findByName("ROLE_ADMIN")
                .orElseGet(() -> {
                    System.out.println("Creating ROLE_ADMIN...");
                    ge.croco.NotificationsApp.user.entity.Role role = new ge.croco.NotificationsApp.user.entity.Role();
                    role.setName("ROLE_ADMIN");
                    return roleRepository.save(role);
                });
        user.getRoles().add(admin);
        appUserRepository.save(user);
    }
}
