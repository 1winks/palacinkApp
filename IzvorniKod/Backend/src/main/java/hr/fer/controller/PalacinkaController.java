package hr.fer.controller;

import hr.fer.domain.Palacinka;
import hr.fer.service.PalacinkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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

    @PostMapping("/add")
    public Palacinka createPalacinka(@RequestBody Palacinka palacinka) {
        return palacinkaService.createPalacinka(palacinka);
    }
}