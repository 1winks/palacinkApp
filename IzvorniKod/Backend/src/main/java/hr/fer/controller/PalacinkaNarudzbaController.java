package hr.fer.controller;

import hr.fer.domain.Palacinka;
import hr.fer.domain.PalacinkaNarudzba;
import hr.fer.service.PalacinkaNarudzbaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/resursi/palacinke-narudzbe")
public class PalacinkaNarudzbaController {

    @Autowired
    private PalacinkaNarudzbaService palacinkaNarudzbaService;

    @GetMapping("/narudzba/{narudzbaId}")
    public List<Palacinka> getPalacinkaForNarudzba(@PathVariable Long narudzbaId) {
        return palacinkaNarudzbaService.getPalacinkaForNarudzba(narudzbaId);
    }
}
