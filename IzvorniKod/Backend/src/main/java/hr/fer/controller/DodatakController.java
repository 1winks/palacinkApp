package hr.fer.controller;

import hr.fer.domain.Dodatak;
import hr.fer.domain.Palacinka;
import hr.fer.dto.DodatakDTO;
import hr.fer.service.DodatakService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/resursi/dodaci")
public class DodatakController {

    @Autowired
    private DodatakService dodatakService;

    @GetMapping("")
    public List<Dodatak> listDodatci() {
        return dodatakService.listAll();
    }

    @PostMapping("/add")
    public Dodatak createDodatak(@RequestBody DodatakDTO dodatak) {
        return dodatakService.createDodatak(dodatak);
    }
}
