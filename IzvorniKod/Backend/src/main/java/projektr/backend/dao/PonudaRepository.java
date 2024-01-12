package projektr.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import projektr.backend.domain.Ponuda;

public interface PonudaRepository extends JpaRepository<Ponuda, Long> {
    // TODO: SQL pozivi za ponuda tablicu u bazi

}
