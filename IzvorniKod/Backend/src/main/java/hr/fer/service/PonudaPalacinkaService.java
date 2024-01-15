package hr.fer.service;

import hr.fer.domain.PonudaPalacinka;
import java.util.List;

public interface PonudaService {
    List<PonudaPalacinka> listAll();

    PonudaPalacinka createPonuda(PonudaPalacinka ponudaPalacinka);
}
