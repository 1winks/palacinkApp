package hr.fer;

import hr.fer.entity.auth.User;
import hr.fer.security.CustomUserDetailsService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ProjektRApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjektRApplication.class, args);
		System.out.println("\nRunning\n");
	}

	@Bean
	CommandLineRunner init(CustomUserDetailsService userService, PasswordEncoder passwordEncoder) {
		return args -> {
			// Provjerite postoji li već korisnik 'admin'
			if (!userService.existsByEmail("admin")) {
				// Kreiranje korisnika 'admin'
				User adminUser = User.builder()
						.name("Admin User")
						.username("admin")
						.email("admin")
						.password(passwordEncoder.encode("pass"))
						.role("admin")
						// Dodajte ostale atribute kao što su role, itd.
						.build();

				userService.createUser(adminUser);
			}
		};
	}
}
