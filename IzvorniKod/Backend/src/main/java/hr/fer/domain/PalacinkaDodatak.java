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
@Table(name = "PalacinkaDodatak", schema = "public")
public class PalacinkaDodatak {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "dodatak_id")
    private Dodatak dodatak;

    @ManyToOne
    @JoinColumn(name = "palacinka_id")
    private Palacinka palacinka;
}
