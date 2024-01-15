package hr.fer.controller;

import hr.fer.domain.PonudaDodaci;
import hr.fer.service.PonudaDodaciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/resursi/ponude/dodaci")
public class PonudaDodaciController {

    @Autowired
    private PonudaDodaciService ponudaDodaciService;

    @GetMapping("")
    public List<PonudaDodaci> listPonude() {
        return ponudaDodaciService.listAll();
    }

    @PostMapping("/add")
    public PonudaDodaci createPonuda(@RequestBody PonudaDodaci ponudaDodaci) {
        return ponudaDodaciService.createPonuda(ponudaDodaci);
    }
}
