package hr.fer.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "ponudaDod", schema = "public")
public class PonudaDodaci {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String imePonudeDodatka;

    @Column(nullable = false)
    private float cijenaPonudeDodatka;
}
