package projektr.backend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import projektr.backend.domain.Narudzba;
import projektr.backend.service.NarudzbaService;
import java.util.List;

@RestController
@RequestMapping("/narudzbe")
public class NarudzbaController {

    @Autowired
    private NarudzbaService narudzbaService;

    @GetMapping("")
    public List<Narudzba> listNarudzba() {
        return narudzbaService.listAll();
    }

    @PostMapping("/add")
    public Narudzba createNarudzba(@RequestBody Narudzba narudzba) {
        return narudzbaService.createNarudzba(narudzba);
    }

}
