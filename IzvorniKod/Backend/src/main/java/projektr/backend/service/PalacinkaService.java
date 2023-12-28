package projektr.backend.service;

import projektr.backend.domain.Palacinka;

import java.util.List;

public interface PalacinkaService {
    List<Palacinka> listAll();

    Palacinka createPalacinka(Palacinka palacinka);
}
