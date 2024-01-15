package hr.fer.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "ponudaDodaci", schema = "public")
public class PonudaDodaci {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String imePonudeDodatka;

    @Column(nullable = false)
    private float cijenaPonudeDodatka;

}
