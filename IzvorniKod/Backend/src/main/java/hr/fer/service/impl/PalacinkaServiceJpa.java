package hr.fer.service.impl;

import hr.fer.domain.Dodatak;
import hr.fer.domain.Palacinka;
import hr.fer.domain.PalacinkaDodatak;
import hr.fer.dto.DodatakDTO;
import hr.fer.dto.PalacinkaDTO;
import hr.fer.repository.DodatakRepository;
import hr.fer.repository.PalacinkaRepository;
import hr.fer.service.DodatakService;
import hr.fer.service.PalacinkaDodatakService;
import hr.fer.service.PalacinkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PalacinkaServiceJpa implements PalacinkaService {

    @Autowired
    private PalacinkaRepository palacinkaRepo;

    @Autowired
    private DodatakRepository dodatakRepo;

    @Autowired
    private DodatakService dodatakService;

    @Autowired
    private PalacinkaDodatakService PalacinkaDodatakService;

    @Override
    public List<Palacinka> listAll() {
        return palacinkaRepo.findAll();
    }

    @Override
    public Palacinka createPalacinka(PalacinkaDTO palacinkaDTO) {
        Palacinka palacinka = new Palacinka();
        palacinka.setImePalacinke(palacinkaDTO.getImePalacinke());
        palacinka.setCijenaPalacinke(palacinkaDTO.getCijenaPalacinke());
        palacinka.setCustomPalacinka(palacinkaDTO.isCustomPancake());
        Set<DodatakDTO> dodaci = palacinkaDTO.getDodaci();
        System.out.println(dodaci);

        Set<PalacinkaDodatak> palacinkaDodaci = new HashSet<>();
        for (DodatakDTO dodatakDTO:dodaci) {
            Dodatak dodatak = dodatakService.createDodatak(dodatakDTO);
            System.out.println(dodatak);

            palacinka = palacinkaRepo.save(palacinka);
            dodatak = dodatakRepo.save(dodatak);
            PalacinkaDodatak palacinkaDodatak = PalacinkaDodatakService.createPalacinkaDodatak(palacinka, dodatak);
            System.out.println(palacinkaDodatak);

            Set<PalacinkaDodatak> dodatakPomocni = new HashSet<>();
            Set<PalacinkaDodatak> dodatakSet = dodatak.getPalacinkaDodaci();
            System.out.println(dodatakPomocni);
            System.out.println(dodatakSet);

            dodatakPomocni.addAll(dodatakSet);
            System.out.println(dodatakPomocni);
            dodatakPomocni.add(palacinkaDodatak);
            System.out.println(dodatakPomocni);

            dodatak.setPalacinkaDodaci(dodatakPomocni);
            System.out.println("settani dodaci 1");
            System.out.println(dodatak.getPalacinkaDodaci());
            System.out.println("settani dodaci 2");
            dodatak = dodatakRepo.save(dodatak);
            System.out.println("saveani dodaci");

            palacinkaDodaci.add(palacinkaDodatak);
        }
        palacinka.setPalacinkaDodaci(palacinkaDodaci);

        System.out.println("vani sam");
        palacinka = palacinkaRepo.save(palacinka);
        System.out.println(palacinka);
        return palacinka;
    }

    @Override
    public Palacinka addPalacinka(PalacinkaDTO palacinkaDTO) {
        Palacinka palacinka = new Palacinka();
        palacinka.setImePalacinke(palacinkaDTO.getImePalacinke());
        palacinka.setCijenaPalacinke(palacinkaDTO.getCijenaPalacinke());
        palacinka.setCustomPalacinka(palacinkaDTO.isCustomPancake());
        Set<DodatakDTO> dodaci = palacinkaDTO.getDodaci();
        System.out.println(dodaci);

        Set<PalacinkaDodatak> palacinkaDodaci = new HashSet<>();
        for (DodatakDTO dodatakDTO:dodaci) {
            Dodatak dodatak = dodatakRepo.findByNazivDodatka(dodatakDTO.getNazivDodatka());
            System.out.println(dodatak);

            palacinka = palacinkaRepo.save(palacinka);
            dodatak = dodatakRepo.save(dodatak);
            PalacinkaDodatak palacinkaDodatak = PalacinkaDodatakService.createPalacinkaDodatak(palacinka, dodatak);
            System.out.println(palacinkaDodatak);

            Set<PalacinkaDodatak> dodatakPomocni = new HashSet<>();
            Set<PalacinkaDodatak> dodatakSet = dodatak.getPalacinkaDodaci();
            System.out.println(dodatakPomocni);
            System.out.println(dodatakSet);

            dodatakPomocni.addAll(dodatakSet);
            System.out.println(dodatakPomocni);
            dodatakPomocni.add(palacinkaDodatak);
            System.out.println(dodatakPomocni);

            dodatak.setPalacinkaDodaci(dodatakPomocni);
            System.out.println("settani dodaci 1");
            System.out.println(dodatak.getPalacinkaDodaci());
            System.out.println("settani dodaci 2");
            dodatak = dodatakRepo.save(dodatak);
            System.out.println("saveani dodaci");

            palacinkaDodaci.add(palacinkaDodatak);
        }
        palacinka.setPalacinkaDodaci(palacinkaDodaci);

        System.out.println("vani sam");
        palacinka = palacinkaRepo.save(palacinka);
        System.out.println(palacinka);
        return palacinka;
    }
}
