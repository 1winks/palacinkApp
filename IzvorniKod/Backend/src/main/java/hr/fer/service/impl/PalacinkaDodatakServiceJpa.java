package hr.fer.service.impl;

import hr.fer.domain.Dodatak;
import hr.fer.domain.Palacinka;
import hr.fer.domain.PalacinkaDodatak;
import hr.fer.repository.DodatakRepository;
import hr.fer.repository.PalacinkaDodatakRepository;
import hr.fer.repository.PalacinkaRepository;
import hr.fer.service.PalacinkaDodatakService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class PalacinkaDodatakServiceJpa implements PalacinkaDodatakService {

    @Autowired
    private PalacinkaDodatakRepository palacinkaDodatakRepo;

    @Autowired
    private PalacinkaRepository palacinkaRepo;

    @Autowired
    private DodatakRepository dodatakRepo;

    @Override
    public List<Dodatak> getDodatakForPalacinka(Long palacinkaId) {
        Palacinka palacinka = palacinkaRepo.findById(palacinkaId)
                .orElseThrow(() -> new RuntimeException("Palacinka not found with ID: " + palacinkaId));

        List<PalacinkaDodatak> radnaLista = palacinkaDodatakRepo.findAllByPalacinka(palacinka);
        List<Dodatak> listaDodataka = new ArrayList<>();

        for (PalacinkaDodatak palacinkaDodatak:radnaLista) {
            Dodatak dodatak = dodatakRepo.findByNazivDodatka(palacinkaDodatak.getDodatak().getNazivDodatka());
            listaDodataka.add(dodatak);
        }

        return listaDodataka;
    }

    @Override
    public PalacinkaDodatak createPalacinkaDodatak(Palacinka palacinka, Dodatak dodatak) {
        PalacinkaDodatak palacinkaDodatak = new PalacinkaDodatak();
        palacinkaDodatak.setPalacinka(palacinka);
        palacinkaDodatak.setDodatak(dodatak);
        return palacinkaDodatakRepo.save(palacinkaDodatak);
    }
}
