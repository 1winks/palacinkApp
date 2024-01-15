package hr.fer.service.impl;

import hr.fer.domain.Dodatak;
import hr.fer.repository.DodatakRepository;
import hr.fer.service.DodatakService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import java.util.List;
@Service
public class DodatakServiceJpa implements DodatakService {
    @Autowired
    private DodatakRepository dodatakRepo;
    @Override
    public List<Dodatak> listAll() {
        return dodatakRepo.findAll();
    }

    @Override
    public Dodatak createDodatak(Dodatak dodatak) {
        Assert.notNull(dodatak, "Dodatak must be given");
        Assert.isNull(dodatak.getId(),
                "Dodatak ID must be null, not " + dodatak.getId()
        );
        return dodatakRepo.save(dodatak);
    }
}
