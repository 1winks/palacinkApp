package projektr.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import projektr.backend.dao.NarudzbaRepository;
import projektr.backend.domain.Narudzba;
import projektr.backend.service.NarudzbaService;
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
