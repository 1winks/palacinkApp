package hr.fer.service;

import hr.fer.domain.Dodatak;
import hr.fer.domain.Palacinka;
import hr.fer.domain.PalacinkaDodatak;

import java.util.List;

public interface PalacinkaDodatakService {
    List<Dodatak> getDodatakForPalacinka(Long palacinkaId);

    PalacinkaDodatak createPalacinkaDodatak(Palacinka palacinka, Dodatak dodatak);
}
