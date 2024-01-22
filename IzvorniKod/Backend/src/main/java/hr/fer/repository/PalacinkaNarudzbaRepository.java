package hr.fer.repository;

import hr.fer.domain.Narudzba;
import hr.fer.domain.PalacinkaNarudzba;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PalacinkaNarudzbaRepository extends JpaRepository<PalacinkaNarudzba, Long> {

    List<PalacinkaNarudzba> findAllByNarudzba(Narudzba narudzba);
}
