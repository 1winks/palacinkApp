package hr.fer.service;

import hr.fer.domain.Ponuda;
import java.util.List;

public interface PonudaService {
    List<Ponuda> listAll();

    Ponuda createPonuda(Ponuda ponuda);
}
