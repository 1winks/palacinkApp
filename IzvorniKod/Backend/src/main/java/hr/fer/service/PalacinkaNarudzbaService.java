package hr.fer.service;

import hr.fer.domain.Narudzba;
import hr.fer.domain.Palacinka;
import hr.fer.domain.PalacinkaNarudzba;

import java.util.List;

public interface PalacinkaNarudzbaService {

    List<PalacinkaNarudzba> getPalacinkaForNarudzba(Long narudzbaId);

    PalacinkaNarudzba createPalacinkaNarudzba(Narudzba narudzba, Palacinka palacinka);
}
