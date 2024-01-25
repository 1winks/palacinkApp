package hr.fer.controller;

import hr.fer.domain.Palacinka;
import hr.fer.dto.DodatakDTO;
import hr.fer.dto.PalacinkaDTO;
import hr.fer.service.PalacinkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping("/api/resursi/palacinke")
public class PalacinkaController {

    @Autowired
    private PalacinkaService palacinkaService;

    @GetMapping("")
    public List<Palacinka> listPalacinke() {
        return palacinkaService.listAll();
    }

    @PostMapping("/create")
    public Palacinka createPalacinka(@RequestBody PalacinkaDTO palacinka) {
        return palacinkaService.createPalacinka(palacinka);
    }

    @PostMapping("/add")
    public Palacinka addPalacinka(@RequestBody PalacinkaDTO palacinka) {
        return palacinkaService.addPalacinka(palacinka);
    }
}
