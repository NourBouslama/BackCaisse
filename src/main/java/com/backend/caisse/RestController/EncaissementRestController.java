package com.backend.caisse.RestController;

import com.backend.caisse.entities.Encaissement;
import com.backend.caisse.entities.SessionCaisse;
import com.backend.caisse.service.EncaissementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/encaissement")
@CrossOrigin(origins = "*")
public class EncaissementRestController {

    @Autowired
    EncaissementService encaissementService;

    @RequestMapping(path = "/listerEncaissements",method = RequestMethod.GET)
    public ResponseEntity<Object> listerEncaissements() {
        try{
            return new ResponseEntity<Object>(encaissementService.listerEncaissements(),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "/listerEncaissementsParEtatETSession/{etat}/{nums}",method = RequestMethod.GET)
    public ResponseEntity<Object> listerEncaissementsParEtatETSession(@PathVariable("etat") String etat,@PathVariable("nums") Long nums) {
        try{
            return new ResponseEntity<Object>(encaissementService.listerEncaissementsParEtatETSession(etat,nums),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(path = "/listerEncaissementsParSession/{session}",method = RequestMethod.GET)
    public ResponseEntity<Object> listerEncaissementsParSession(@PathVariable("session") Long session) {
        try{
            return new ResponseEntity<Object>(encaissementService.listerEncaissementsParSession(session),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
   
    @RequestMapping(path = "/listerParEtatEtPaiementMode/{etat}/{mode}",method = RequestMethod.GET)
    public ResponseEntity<Object> listerEncaissementParEtatEtPaiementMode(@PathVariable("etat") String etat,@PathVariable("mode") String mode) {
        try{
            return new ResponseEntity<Object>(encaissementService.listerEncaissementParEtatEtPaiementMode(etat,mode),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value="/ajouterEncaissement",method = RequestMethod.POST)
    public ResponseEntity<Object> ajouterEncaissement(@RequestBody Encaissement encaissement) {
        try{
            return new ResponseEntity<Object>(encaissementService.ajouterEncaissement(encaissement),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
