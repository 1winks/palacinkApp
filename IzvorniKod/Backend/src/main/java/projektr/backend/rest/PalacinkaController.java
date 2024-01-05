package projektr.backend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import projektr.backend.domain.Palacinka;
import projektr.backend.service.PalacinkaService;

import java.util.List;

@RestController
@RequestMapping("/palacinke")
public class PalacinkaController {

    @Autowired
    private PalacinkaService palacinkaService;

    @GetMapping("")
    public List<Palacinka> listPalacinke() {
        return palacinkaService.listAll();
    }

    @PostMapping("/add")
    @Secured("ROLE_ADMIN")
    public Palacinka createPalacinka(@RequestBody Palacinka palacinka) {
        return palacinkaService.createPalacinka(palacinka);
    }
}
