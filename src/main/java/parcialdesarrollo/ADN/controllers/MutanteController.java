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

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/mutant")
public class MutanteController {


    private final MutanteService mutanteService;


    public MutanteController(MutanteService mutanteService){
        this.mutanteService = mutanteService;
    }


    @PostMapping
    public ResponseEntity<?> esMutante(@RequestBody Map<String,List<String>> request){

        List<String> dnaList = request.get("dna");
        String[] dna = dnaList.toArray(new String[0]);

        boolean isMutant = mutanteService.analyzeDna(dna);


        if (isMutant) {
            return  ResponseEntity.status(HttpStatus.OK).body("El ADN pertenece a un mutante");
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("El ADN no pertenece a un mutante");
        }
    }

}
