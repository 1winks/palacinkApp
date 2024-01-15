package hr.fer.domain;

import hr.fer.entity.auth.User;
import lombok.*;
import lombok.experimental.SuperBuilder;
import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "narudzba", schema = "public")
public class Narudzba {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private float cijenaNarudzbe;

    @Column(nullable = false)
    private Boolean dostava;

    private String adresa;

    @OneToMany(mappedBy = "narudzba")
    private Set<Palacinka> palacinke;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
