package hr.fer.repository;

import hr.fer.domain.Dodatak;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DodatakRepository extends JpaRepository<Dodatak, Long> {

}
