package projektr.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import projektr.backend.dao.PalacinkaRepository;
import projektr.backend.domain.Palacinka;
import projektr.backend.service.PalacinkaService;
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
