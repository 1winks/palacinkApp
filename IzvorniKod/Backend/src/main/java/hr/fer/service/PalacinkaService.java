package hr.fer.service;

import hr.fer.domain.Palacinka;
import hr.fer.domain.PalacinkaDodatak;
import hr.fer.dto.DodatakDTO;
import hr.fer.dto.PalacinkaDTO;

import java.util.List;
import java.util.Set;

public interface PalacinkaService {
    List<Palacinka> listAll();

    Palacinka createPalacinka(PalacinkaDTO palacinka);
}
