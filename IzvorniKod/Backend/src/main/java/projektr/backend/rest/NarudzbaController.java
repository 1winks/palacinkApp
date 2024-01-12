package projektr.backend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
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
    @Secured("ROLE_ADMIN")
    public Narudzba createNarudzba(@RequestBody Narudzba narudzba) {
        return narudzbaService.createNarudzba(narudzba);
    }

}
