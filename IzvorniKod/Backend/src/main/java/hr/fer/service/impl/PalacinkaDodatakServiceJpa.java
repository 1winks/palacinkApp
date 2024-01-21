package hr.fer.service.impl;

import hr.fer.domain.Dodatak;
import hr.fer.domain.Palacinka;
import hr.fer.domain.PalacinkaDodatak;
import hr.fer.repository.PalacinkaDodatakRepository;
import hr.fer.repository.PalacinkaRepository;
import hr.fer.service.PalacinkaDodatakService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PalacinkaDodatakServiceJpa implements PalacinkaDodatakService {

    @Autowired
    private PalacinkaRepository palacinkaRepo;

    @Autowired
    private PalacinkaDodatakRepository palacinkaDodatakRepo;

    @Override
    public List<PalacinkaDodatak> getDodatakForPalacinka(Long palacinkaId) {
        Palacinka palacinka = palacinkaRepo.findById(palacinkaId)
                .orElseThrow(() -> new RuntimeException("Palacinka not found with ID: " + palacinkaId));
        return palacinkaDodatakRepo.findAllByPalacinka(palacinka);
    }

    @Override
    public PalacinkaDodatak createPalacinkaDodatak(Palacinka palacinka, Dodatak dodatak) {
        PalacinkaDodatak palacinkaDodatak = new PalacinkaDodatak();
        palacinkaDodatak.setPalacinka(palacinka);
        palacinkaDodatak.setDodatak(dodatak);
        return palacinkaDodatakRepo.save(palacinkaDodatak);
    }
}
