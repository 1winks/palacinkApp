package projektr.backend.service;

import projektr.backend.domain.Ponuda;
import java.util.List;

public interface PonudaService {
    List<Ponuda> listAll();

    Ponuda createPonuda(Ponuda ponuda);
}
