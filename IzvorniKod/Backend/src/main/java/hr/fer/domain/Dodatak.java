package hr.fer.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;
import javax.persistence.*;

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

    // palacinka

    // ponuda
}
