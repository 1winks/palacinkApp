package hr.fer.controller;

import hr.fer.domain.Narudzba;
import hr.fer.dto.NarudzbaDTO;
import hr.fer.service.NarudzbaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/resursi/narudzbe")
public class NarudzbaController {

    @Autowired
    private NarudzbaService narudzbaService;

    @GetMapping("")
    public List<Narudzba> listNarudzba() {
        return narudzbaService.listAll();
    }

    @PostMapping("/add")
    public Narudzba createNarudzba(@RequestBody NarudzbaDTO narudzba) {
        return narudzbaService.createNarudzba(narudzba);
    }
}
