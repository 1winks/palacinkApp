package hr.fer.service.impl;

import hr.fer.domain.Narudzba;
import hr.fer.domain.Palacinka;
import hr.fer.domain.PalacinkaDodatak;
import hr.fer.domain.PalacinkaNarudzba;
import hr.fer.dto.NarudzbaDTO;
import hr.fer.dto.PalacinkaDTO;
import hr.fer.repository.NarudzbaRepository;
import hr.fer.repository.PalacinkaRepository;
import hr.fer.service.NarudzbaService;
import hr.fer.service.PalacinkaNarudzbaService;
import hr.fer.service.PalacinkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class NarudzbaServiceJpa implements NarudzbaService {

    @Autowired
    private NarudzbaRepository narudzbaRepo;

    @Autowired
    private PalacinkaRepository palacinkaRepo;

    @Autowired
    private PalacinkaService palacinkaService;

    @Autowired
    private PalacinkaNarudzbaService palacinkaNarudzbaService;

    @Override
    public List<Narudzba> listAll() {
        return narudzbaRepo.findAll();
    }

    @Override
    public Narudzba createNarudzba(NarudzbaDTO narudzbaDTO) {
        Narudzba narudzba = new Narudzba();
        narudzba.setAdresa(narudzbaDTO.getAdresa());
        narudzba.setDostava(narudzbaDTO.getDostava());
        narudzba.setCijenaNarudzbe(narudzbaDTO.getCijenaNarudzbe());
        Set<PalacinkaDTO> palacinkaDTOSet = narudzbaDTO.getPalacinke();
        System.out.println(palacinkaDTOSet);

        Set<PalacinkaNarudzba> palacinkaNarudzbe = new HashSet<>();
        for (PalacinkaDTO palacinkaDTO:palacinkaDTOSet) {
            Palacinka palacinka = palacinkaService.createPalacinka(palacinkaDTO);
            System.out.println(palacinka);

            narudzba = narudzbaRepo.save(narudzba);
            palacinka = palacinkaRepo.save(palacinka);
            PalacinkaNarudzba palacinkaNarudzba = palacinkaNarudzbaService.createPalacinkaNarudzba(narudzba, palacinka);
            System.out.println(palacinkaNarudzba);

            Set<PalacinkaNarudzba> palacinkaPomocni = new HashSet<>();
            Set<PalacinkaNarudzba> palacinkaSet = palacinka.getPalacinkaNarudzbe();
            System.out.println(palacinkaPomocni);
            System.out.println(palacinkaSet);

            palacinkaPomocni.addAll(palacinkaSet);
            System.out.println(palacinkaPomocni);
            palacinkaPomocni.add(palacinkaNarudzba);
            System.out.println(palacinkaPomocni);

            palacinka.setPalacinkaNarudzbe(palacinkaPomocni);
            System.out.println("settane palacinke 1");
            System.out.println(palacinka.getPalacinkaNarudzbe());
            System.out.println("settane palacinke 2");
            palacinka = palacinkaRepo.save(palacinka);
            System.out.println("saveani dodaci");

            palacinkaNarudzbe.add(palacinkaNarudzba);
        }
        narudzba.setPalacinkaNarudzbe(palacinkaNarudzbe);

        System.out.println("vani sam");
        narudzba = narudzbaRepo.save(narudzba);
        System.out.println(narudzba);

        return narudzba;
    }

    @Override
    public Narudzba addNarudzba(NarudzbaDTO narudzbaDTO) {
        Narudzba narudzba = new Narudzba();
        narudzba.setAdresa(narudzbaDTO.getAdresa());
        narudzba.setDostava(narudzbaDTO.getDostava());
        narudzba.setCijenaNarudzbe(narudzbaDTO.getCijenaNarudzbe());
        Set<PalacinkaDTO> palacinkaDTOSet = narudzbaDTO.getPalacinke();
        System.out.println(palacinkaDTOSet);

        Set<PalacinkaNarudzba> palacinkaNarudzbe = new HashSet<>();
        for (PalacinkaDTO palacinkaDTO:palacinkaDTOSet) {
            Palacinka palacinka = palacinkaRepo.findByImePalacinke(palacinkaDTO.getImePalacinke());
            System.out.println(palacinka);

            narudzba = narudzbaRepo.save(narudzba);
            palacinka = palacinkaRepo.save(palacinka);
            PalacinkaNarudzba palacinkaNarudzba = palacinkaNarudzbaService.createPalacinkaNarudzba(narudzba, palacinka);
            System.out.println(palacinkaNarudzba);

            Set<PalacinkaNarudzba> palacinkaPomocni = new HashSet<>();
            Set<PalacinkaNarudzba> palacinkaSet = palacinka.getPalacinkaNarudzbe();
            System.out.println(palacinkaPomocni);
            System.out.println(palacinkaSet);

            palacinkaPomocni.addAll(palacinkaSet);
            System.out.println(palacinkaPomocni);
            palacinkaPomocni.add(palacinkaNarudzba);
            System.out.println(palacinkaPomocni);

            palacinka.setPalacinkaNarudzbe(palacinkaPomocni);
            System.out.println("settane palacinke 1");
            System.out.println(palacinka.getPalacinkaNarudzbe());
            System.out.println("settane palacinke 2");
            palacinka = palacinkaRepo.save(palacinka);
            System.out.println("saveani dodaci");

            palacinkaNarudzbe.add(palacinkaNarudzba);
        }
        narudzba.setPalacinkaNarudzbe(palacinkaNarudzbe);

        System.out.println("vani sam");
        narudzba = narudzbaRepo.save(narudzba);
        System.out.println(narudzba);

        return narudzba;
    }
}
