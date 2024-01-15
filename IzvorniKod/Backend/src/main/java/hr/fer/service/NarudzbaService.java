package hr.fer.service;

import hr.fer.domain.Narudzba;
import java.util.List;

public interface NarudzbaService {
    List<Narudzba> listAll();

    Narudzba createNarudzba(Narudzba narudzba);
}
