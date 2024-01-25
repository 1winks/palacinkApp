package hr.fer.service;

import hr.fer.domain.Narudzba;
import hr.fer.dto.NarudzbaDTO;

import java.util.List;

public interface NarudzbaService {
    List<Narudzba> listAll();

    Narudzba createNarudzba(NarudzbaDTO narudzba);

    Narudzba addNarudzba(NarudzbaDTO narudzba);
}
