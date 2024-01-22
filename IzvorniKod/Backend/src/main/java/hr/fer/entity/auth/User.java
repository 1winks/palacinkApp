package hr.fer.entity.auth;

import hr.fer.domain.Narudzba;
import lombok.*;
import lombok.experimental.SuperBuilder;
import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "user", schema = "public")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String name;
    private String username;
    private String email;
    private String password;
    private String role;

    /*
    @OneToMany(mappedBy = "user")
    private Set<Narudzba> narudzbe;
     */
}
