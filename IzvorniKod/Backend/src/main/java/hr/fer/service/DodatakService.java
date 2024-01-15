package hr.fer.service;

import hr.fer.domain.Dodatak;
import java.util.List;

public interface DodatakService {
    List<Dodatak> listAll();

    Dodatak createDodatak(Dodatak dodatak);
}
