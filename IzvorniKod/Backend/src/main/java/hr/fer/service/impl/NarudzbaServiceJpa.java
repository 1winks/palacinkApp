package hr.fer.service.impl;

import hr.fer.domain.Narudzba;
import hr.fer.repository.NarudzbaRepository;
import hr.fer.service.NarudzbaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class NarudzbaServiceJpa implements NarudzbaService {

    @Autowired
    private NarudzbaRepository narudzbaRepo;
    @Override
    public List<Narudzba> listAll() {
        return narudzbaRepo.findAll();
    }

    @Override
    public Narudzba createNarudzba(Narudzba narudzba) {
        Assert.notNull(narudzba, "Narudzba must be given");
        Assert.isNull(narudzba.getId(),
                "Narudzba ID must be null, not " + narudzba.getId()
        );
        return narudzbaRepo.save(narudzba);
    }
}
