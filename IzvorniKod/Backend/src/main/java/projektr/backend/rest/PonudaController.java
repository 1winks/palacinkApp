package projektr.backend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import projektr.backend.domain.Ponuda;
import projektr.backend.service.PonudaService;
import java.util.List;

@RestController
@RequestMapping("/ponude")
public class PonudaController {

    @Autowired
    private PonudaService ponudaService;

    @GetMapping("")
    public List<Ponuda> listPonude() {
        return ponudaService.listAll();
    }

    @PostMapping("/add")
    @Secured("ROLE_ADMIN")
    public Ponuda createPonuda(@RequestBody Ponuda ponuda) {
        return ponudaService.createPonuda(ponuda);
    }

}
