package hr.fer.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;
import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "narudzba", schema = "public")
public class Narudzba {
    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private float cijenaNarudzbe;

    @Column(nullable = false)
    private Boolean dostava;

    private String adresa;

    // palacinke
}
