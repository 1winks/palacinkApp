package projektr.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import projektr.backend.dao.KorisnikRepository;
import projektr.backend.domain.Korisnik;
import projektr.backend.service.KorisnikService;

import java.util.List;
@Service
public class KorisnikServiceJpa implements KorisnikService {

    @Autowired
    private KorisnikRepository korisnikRepo;

    @Override
    public List<Korisnik> listAll() {
        return korisnikRepo.findAll();
    }

    @Override
    public Korisnik createKorisnik(Korisnik korisnik) {
        Assert.notNull(korisnik, "Korisnik must be given");
        Assert.isNull(korisnik.getId(),
                "Korisnik ID must be null, not " + korisnik.getId()
        );
        return korisnikRepo.save(korisnik);
    }

}
