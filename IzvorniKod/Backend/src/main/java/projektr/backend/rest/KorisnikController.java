package projektr.backend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import projektr.backend.domain.Korisnik;
import projektr.backend.service.KorisnikService;
import java.util.List;

@RestController
@RequestMapping("/users")
public class KorisnikController {

    @Autowired
    private KorisnikService korisnikService;

    @GetMapping("")
    public List<Korisnik> listKorisnici() {
        return korisnikService.listAll();
    }

    @PostMapping("/add")
    @Secured("ROLE_ADMIN")
    public Korisnik createKorisnik(@RequestBody Korisnik korisnik) {
        return korisnikService.createKorisnik(korisnik);
    }
}
