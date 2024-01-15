package hr.fer.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "ponudaPalacinka", schema = "public")
public class PonudaPalacinka {
    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String imePonudePalacinke;

    @Column(nullable = false)
    private float cijenaPonudePalacinke;

    // ponuda dodaci

}
