package projektr.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import projektr.backend.domain.Korisnik;

import java.util.Optional;

public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {
    // TODO: SQL pozivi za korisnik tablicu u bazi

}
