package hr.fer.repository;

import hr.fer.domain.Palacinka;
import hr.fer.domain.PalacinkaDodatak;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PalacinkaDodatakRepository extends JpaRepository<PalacinkaDodatak, Long> {
    List<PalacinkaDodatak> findAllByPalacinka(Palacinka palacinka);
}
