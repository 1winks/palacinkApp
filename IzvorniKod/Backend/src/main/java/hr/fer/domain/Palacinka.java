package hr.fer.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;
import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "palacinka", schema = "public")
public class Palacinka {
    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String imePalacinke;

    @Column(nullable = false)
    private float cijenaPalacinke;
    public enum Type {
        NORMAL,
        CUSTOM;
    }
    @Enumerated(EnumType.STRING)
    private Type tipPalacinke;

    // narudzba

    // dodaci
}
