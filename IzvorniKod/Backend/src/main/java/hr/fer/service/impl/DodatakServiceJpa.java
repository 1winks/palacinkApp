package hr.fer.service.impl;

import hr.fer.domain.Dodatak;
import hr.fer.domain.Palacinka;
import hr.fer.dto.DodatakDTO;
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
    public Dodatak createDodatak(DodatakDTO dodatakDTO) {
        Dodatak dodatak = new Dodatak();
        dodatak.setNazivDodatka(dodatakDTO.getNazivDodatka());
        dodatak.setCijenaDodatka(dodatakDTO.getCijenaDodatka());
        return dodatakRepo.save(dodatak);
    }
}
