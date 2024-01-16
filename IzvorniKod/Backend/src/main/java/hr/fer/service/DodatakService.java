package hr.fer.service;

import hr.fer.domain.Dodatak;
import hr.fer.domain.Palacinka;
import hr.fer.dto.DodatakDTO;

import java.util.List;

public interface DodatakService {
    List<Dodatak> listAll();

    Dodatak createDodatak(DodatakDTO dodatak);
}
