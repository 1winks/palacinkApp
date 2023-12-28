package projektr.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import projektr.backend.domain.Dodatak;

public interface DodatakRepository extends JpaRepository<Dodatak, Long> {
    // TODO: SQL pozivi za dodatak tablicu u bazi


}
