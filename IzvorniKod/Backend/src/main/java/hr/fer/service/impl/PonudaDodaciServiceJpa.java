package hr.fer.service.impl;

import hr.fer.domain.PonudaDodaci;
import hr.fer.repository.PonudaDodaciRepository;
import hr.fer.service.PonudaDodaciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import java.util.List;

@Service
public class PonudaDodaciServiceJpa implements PonudaDodaciService {

    @Autowired
    private PonudaDodaciRepository ponudaDodaciRepo;
    @Override
    public List<PonudaDodaci> listAll() {
        return ponudaDodaciRepo.findAll();
    }

    @Override
    public PonudaDodaci createPonuda(PonudaDodaci ponudaDodaci) {
        Assert.notNull(ponudaDodaci, "PonudaDodatak must be given");
        Assert.isNull(ponudaDodaci.getId(),
                "PonudaDodatak ID must be null, not " + ponudaDodaci.getId()
        );
        return ponudaDodaciRepo.save(ponudaDodaci);
    }
}
