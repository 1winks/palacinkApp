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
@Table(name = "ponuda", schema = "public")
public class Ponuda {
    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String imePonude;

    @Column(nullable = false)
    private float cijenaPonude;

    // dodaci

}
