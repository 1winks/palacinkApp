package hr.fer.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@Table(name = "dodatak", schema = "public")
public class Dodatak {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nazivDodatka;

    @Column(nullable = false)
    private float cijenaDodatka;

    @JsonIgnore
    @OneToMany(mappedBy = "dodatak", cascade = CascadeType.ALL)
    private Set<PalacinkaDodatak> palacinkaDodaci = new HashSet<>();
}
