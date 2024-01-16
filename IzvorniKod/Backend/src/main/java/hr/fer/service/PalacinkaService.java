package hr.fer.service;

import hr.fer.domain.Palacinka;
import hr.fer.domain.PalacinkaDodatak;
import hr.fer.dto.PalacinkaDTO;

import java.util.List;

public interface PalacinkaService {
    List<Palacinka> listAll();

    Palacinka createPalacinka(PalacinkaDTO palacinka);
}
