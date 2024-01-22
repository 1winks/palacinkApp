package hr.fer.service.impl;

import hr.fer.domain.Narudzba;
import hr.fer.domain.Palacinka;
import hr.fer.domain.PalacinkaNarudzba;
import hr.fer.repository.NarudzbaRepository;
import hr.fer.repository.PalacinkaNarudzbaRepository;
import hr.fer.service.PalacinkaNarudzbaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PalacinkaNarudzbaServiceJpa implements PalacinkaNarudzbaService {

    @Autowired
    private PalacinkaNarudzbaRepository palacinkaNarudzbaRepo;

    @Autowired
    private NarudzbaRepository narudzbaRepo;

    @Override
    public List<PalacinkaNarudzba> getPalacinkaForNarudzba(Long narudzbaId) {
        Narudzba narudzba = narudzbaRepo.findById(narudzbaId)
                .orElseThrow(() -> new RuntimeException("Narudzba not found with ID: " + narudzbaId));
        return palacinkaNarudzbaRepo.findAllByNarudzba(narudzba);
    }

    @Override
    public PalacinkaNarudzba createPalacinkaNarudzba(Narudzba narudzba, Palacinka palacinka) {
        PalacinkaNarudzba palacinkaNarudzba = new PalacinkaNarudzba();
        palacinkaNarudzba.setPalacinka(palacinka);
        palacinkaNarudzba.setNarudzba(narudzba);
        return palacinkaNarudzbaRepo.save(palacinkaNarudzba);
    }
}
