package hr.fer.service;

import hr.fer.domain.PonudaDodaci;
import java.util.List;

public interface PonudaDodaciService {
    List<PonudaDodaci> listAll();

    PonudaDodaci createPonuda(PonudaDodaci ponudaDodaci);
}
