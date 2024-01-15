package hr.fer.controller;

import hr.fer.domain.PonudaPalacinka;
import hr.fer.service.PonudaPalacinkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/resursi/ponude/palacinke")
public class PonudaPalacinkaController {

    @Autowired
    private PonudaPalacinkaService ponudaPalacinkaService;

    @GetMapping("")
    public List<PonudaPalacinka> listPonude() {
        return ponudaPalacinkaService.listAll();
    }

    @PostMapping("/add")
    public PonudaPalacinka createPonuda(@RequestBody PonudaPalacinka ponudaPalacinka) {
        return ponudaPalacinkaService.createPonuda(ponudaPalacinka);
    }
}
