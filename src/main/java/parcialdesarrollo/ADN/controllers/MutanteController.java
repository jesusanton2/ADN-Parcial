package parcialdesarrollo.ADN.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import parcialdesarrollo.ADN.entities.Mutante;
import parcialdesarrollo.ADN.services.MutanteService;

@RestController
@RequestMapping("/mutant")
public class MutanteController {


    private final MutanteService mutanteService;


    public MutanteController(MutanteService mutanteService){
        this.mutanteService = mutanteService;
    }


    @PostMapping
    public ResponseEntity<?> esMutante(@RequestBody Mutante mutante){

        boolean isMutant = mutanteService.analyzeDna(mutante.getDna());

        if (isMutant) {
            return  ResponseEntity.status(HttpStatus.OK).body("El ADN pertenece a un mutante");
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("El ADN no pertenece a un mutante");
        }
    }

}
