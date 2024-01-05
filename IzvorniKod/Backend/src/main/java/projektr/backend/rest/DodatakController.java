package projektr.backend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import projektr.backend.domain.Dodatak;
import projektr.backend.service.DodatakService;

import java.util.List;

@RestController
@RequestMapping("/dodatci")
public class DodatakController {

    @Autowired
    private DodatakService dodatakService;

    @GetMapping("")
    public List<Dodatak> listDodatci() {
        return dodatakService.listAll();
    }

    @PostMapping("/add")
    @Secured("ROLE_ADMIN")
    public Dodatak createDodatak(@RequestBody Dodatak dodatak) {
        return dodatakService.createDodatak(dodatak);
    }
}
