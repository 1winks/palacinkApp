package projektr.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import projektr.backend.dao.DodatakRepository;
import projektr.backend.domain.Dodatak;
import projektr.backend.service.DodatakService;

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
        Assert.notNull(dodatak, "Palacinka must be given");
        Assert.isNull(dodatak.getId(),
                "Dodatak ID must be null, not " + dodatak.getId()
        );
        return dodatakRepo.save(dodatak);
    }
}
