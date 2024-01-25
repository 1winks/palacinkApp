package hr.fer.service.impl;

import hr.fer.domain.*;
import hr.fer.repository.NarudzbaRepository;
import hr.fer.repository.PalacinkaNarudzbaRepository;
import hr.fer.repository.PalacinkaRepository;
import hr.fer.service.PalacinkaNarudzbaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PalacinkaNarudzbaServiceJpa implements PalacinkaNarudzbaService {

    @Autowired
    private PalacinkaNarudzbaRepository palacinkaNarudzbaRepo;

    @Autowired
    private NarudzbaRepository narudzbaRepo;

    @Autowired
    private PalacinkaRepository palacinkaRepo;

    @Override
    public List<Palacinka> getPalacinkaForNarudzba(Long narudzbaId) {
        Narudzba narudzba = narudzbaRepo.findById(narudzbaId)
                .orElseThrow(() -> new RuntimeException("Narudzba not found with ID: " + narudzbaId));

        List<PalacinkaNarudzba> radnaLista = palacinkaNarudzbaRepo.findAllByNarudzba(narudzba);
        List<Palacinka> listaPalacinka = new ArrayList<>();

        for (PalacinkaNarudzba palacinkaNarudzba:radnaLista) {
            Palacinka palacinka = palacinkaRepo.findByImePalacinke(palacinkaNarudzba.getPalacinka().getImePalacinke());
            listaPalacinka.add(palacinka);
        }

        return listaPalacinka;
    }

    @Override
    public PalacinkaNarudzba createPalacinkaNarudzba(Narudzba narudzba, Palacinka palacinka) {
        PalacinkaNarudzba palacinkaNarudzba = new PalacinkaNarudzba();
        palacinkaNarudzba.setPalacinka(palacinka);
        palacinkaNarudzba.setNarudzba(narudzba);
        return palacinkaNarudzbaRepo.save(palacinkaNarudzba);
    }
}
