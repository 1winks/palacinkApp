package hr.fer.service;

import hr.fer.domain.PonudaPalacinka;
import java.util.List;

public interface PonudaPalacinkaService {
    List<PonudaPalacinka> listAll();

    PonudaPalacinka createPonuda(PonudaPalacinka ponudaPalacinka);
}
