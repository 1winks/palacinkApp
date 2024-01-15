package hr.fer.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;
import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "ponudaPal", schema = "public")
public class PonudaPalacinka {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String imePonudePalacinke;

    @Column(nullable = false)
    private float cijenaPonudePalacinke;
}
