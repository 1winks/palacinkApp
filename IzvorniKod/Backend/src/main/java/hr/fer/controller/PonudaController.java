package hr.fer.controller;

import hr.fer.domain.Ponuda;
import hr.fer.service.PonudaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/resursi/ponude")
public class PonudaController {

    @Autowired
    private PonudaService ponudaService;

    @GetMapping("")
    public List<Ponuda> listPonude() {
        return ponudaService.listAll();
    }

    @PostMapping("/add")
    public Ponuda createPonuda(@RequestBody Ponuda ponuda) {
        return ponudaService.createPonuda(ponuda);
    }
}
