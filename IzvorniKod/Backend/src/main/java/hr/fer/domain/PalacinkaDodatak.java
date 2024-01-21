package hr.fer.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import javax.persistence.*;
import java.util.Objects;

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

    @Override
    public String toString() {
        return "PalacinkaDodatak{" +
                "id=" + id +
                ", dodatak=" + dodatak.getId() +
                ", palacinka=" + palacinka.getId() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PalacinkaDodatak that = (PalacinkaDodatak) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
