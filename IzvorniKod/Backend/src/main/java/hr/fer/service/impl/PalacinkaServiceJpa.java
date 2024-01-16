package hr.fer.service.impl;

import hr.fer.domain.Palacinka;
import hr.fer.dto.PalacinkaDTO;
import hr.fer.repository.PalacinkaRepository;
import hr.fer.service.PalacinkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PalacinkaServiceJpa implements PalacinkaService {

    @Autowired
    private PalacinkaRepository palacinkaRepo;

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
        return palacinkaRepo.save(palacinka);
    }
}
