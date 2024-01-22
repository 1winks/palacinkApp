package hr.fer.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hr.fer.entity.auth.User;
import lombok.*;
import lombok.experimental.SuperBuilder;
import javax.persistence.*;
import java.util.HashSet;
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

    @JsonIgnore
    @OneToMany(mappedBy = "narudzba", cascade = CascadeType.ALL)
    private Set<PalacinkaNarudzba> palacinkaNarudzbe = new HashSet<>();

    /*
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
     */
}
