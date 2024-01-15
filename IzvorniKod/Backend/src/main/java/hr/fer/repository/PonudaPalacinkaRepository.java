package hr.fer.repository;

import hr.fer.domain.PonudaPalacinka;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PonudaRepository extends JpaRepository<PonudaPalacinka, Long> {

}
