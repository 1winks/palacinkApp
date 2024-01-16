package hr.fer.repository;

import hr.fer.domain.Palacinka;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PalacinkaRepository extends JpaRepository<Palacinka, Long> {

}
