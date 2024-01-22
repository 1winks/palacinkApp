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
@Table(name = "PalacinkaNarudzba", schema = "public")
public class PalacinkaNarudzba {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "palacinka_id")
    private Palacinka palacinka;

    @ManyToOne
    @JoinColumn(name = "narudzba_id")
    private Narudzba narudzba;

    @Override
    public String toString() {
        return "PalacinkaNarudzba{" +
                "id=" + id +
                ", palacinka=" + palacinka.getId() +
                ", narudzba=" + narudzba.getId() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PalacinkaNarudzba that = (PalacinkaNarudzba) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
