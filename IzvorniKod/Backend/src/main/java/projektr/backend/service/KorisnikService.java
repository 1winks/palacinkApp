package projektr.backend.service;

import projektr.backend.domain.Korisnik;
import java.util.List;

public interface KorisnikService {
    List<Korisnik> listAll();

    Korisnik createKorisnik(Korisnik korisnik);

}
