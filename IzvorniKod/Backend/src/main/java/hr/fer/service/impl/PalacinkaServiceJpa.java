package hr.fer.service.impl;

import hr.fer.domain.Palacinka;
import hr.fer.repository.PalacinkaRepository;
import hr.fer.service.PalacinkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

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
    public Palacinka createPalacinka(Palacinka palacinka) {
        Assert.notNull(palacinka, "Palacinka must be given");
        Assert.isNull(palacinka.getId(),
                "Palacinka ID must be null, not " + palacinka.getId()
        );
        return palacinkaRepo.save(palacinka);
    }
}
