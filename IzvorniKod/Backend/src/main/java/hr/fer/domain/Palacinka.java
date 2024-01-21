package hr.fer.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "palacinka", schema = "public")
public class Palacinka {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String imePalacinke;

    private float cijenaPalacinke;

    private boolean customPalacinka;

    @JsonIgnore
    @OneToMany(mappedBy = "palacinka", cascade = CascadeType.ALL)
    private Set<PalacinkaDodatak> palacinkaDodaci = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "narudzba_id")
    private Narudzba narudzba;
}
