package projektr.backend.service;

import projektr.backend.domain.Narudzba;
import java.util.List;

public interface NarudzbaService {
    List<Narudzba> listAll();

    Narudzba createNarudzba(Narudzba narudzba);

}
