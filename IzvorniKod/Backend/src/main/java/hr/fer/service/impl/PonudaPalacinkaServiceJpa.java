package hr.fer.service.impl;

import hr.fer.domain.PonudaPalacinka;
import hr.fer.repository.PonudaPalacinkaRepository;
import hr.fer.service.PonudaPalacinkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import java.util.List;
@Service
public class PonudaPalacinkaServiceJpa implements PonudaPalacinkaService {

    @Autowired
    private PonudaPalacinkaRepository ponudaPalacinkaRepo;

    @Override
    public List<PonudaPalacinka> listAll() {
        return ponudaPalacinkaRepo.findAll();
    }

    @Override
    public PonudaPalacinka createPonuda(PonudaPalacinka ponudaPalacinka) {
        Assert.notNull(ponudaPalacinka, "PonudaPalacinka must be given");
        Assert.isNull(ponudaPalacinka.getId(),
                "PonudaPalacinka ID must be null, not " + ponudaPalacinka.getId()
        );
        return ponudaPalacinkaRepo.save(ponudaPalacinka);
    }
}
