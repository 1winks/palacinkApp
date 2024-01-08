package projektr.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import projektr.backend.dao.PonudaRepository;
import projektr.backend.domain.Ponuda;
import projektr.backend.service.PonudaService;
import java.util.List;

@Service
public class PonudaServiceJpa implements PonudaService {

    @Autowired
    private PonudaRepository ponudaRepo;

    @Override
    public List<Ponuda> listAll() {
        return ponudaRepo.findAll();
    }

    @Override
    public Ponuda createPonuda(Ponuda ponuda) {
        Assert.notNull(ponuda, "Ponuda must be given");
        Assert.isNull(ponuda.getId(),
                "Ponuda ID must be null, not " + ponuda.getId()
        );
        return ponudaRepo.save(ponuda);
    }
}
