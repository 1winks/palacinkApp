package hr.fer.controller;

import hr.fer.domain.PalacinkaDodatak;
import hr.fer.service.PalacinkaDodatakService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/api/resursi/palacinke-dodaci")
public class PalacinkaDodatakController {

    @Autowired
    private PalacinkaDodatakService palacinkaDodatakService;

    @GetMapping("/palacinka/{palacinkaId}")
    public List<PalacinkaDodatak> getDodatakForPalacinka(@PathVariable Long palacinkaId) {
        return palacinkaDodatakService.getDodatakForPalacinka(palacinkaId);
    }
}
