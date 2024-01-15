package hr.fer.service;

import hr.fer.domain.Palacinka;

import java.util.List;

public interface PalacinkaService {
    List<Palacinka> listAll();

    Palacinka createPalacinka(Palacinka palacinka);
}
