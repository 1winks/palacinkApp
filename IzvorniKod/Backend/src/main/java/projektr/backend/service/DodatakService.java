package projektr.backend.service;

import projektr.backend.domain.Dodatak;

import java.util.List;

public interface DodatakService {
    List<Dodatak> listAll();

    Dodatak createDodatak(Dodatak dodatak);
}
