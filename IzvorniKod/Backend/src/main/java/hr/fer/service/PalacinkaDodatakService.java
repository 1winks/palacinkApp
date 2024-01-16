package hr.fer.service;

import hr.fer.domain.PalacinkaDodatak;

import java.util.List;

public interface PalacinkaDodatakService {
    List<PalacinkaDodatak> getDodatakForPalacinka(Long palacinkaId);
}
