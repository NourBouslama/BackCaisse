package com.backend.caisse.RestController;

import java.util.List;

import com.backend.caisse.entities.ModePaiement;
import com.backend.caisse.service.ModeService;

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
@RequestMapping("/mode")
@CrossOrigin(origins = "*")
public class ModeRestController {

    @Autowired
    ModeService modeService;

    @RequestMapping(path = "/listerModePaiements",method = RequestMethod.GET)
    public ResponseEntity<Object> listerModePaiements() {
        try{
            return new ResponseEntity<Object>(modeService.listerModePaiements(),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(path = "/listerModePaiementParEtat/{etat}",method = RequestMethod.GET)
    public ResponseEntity<Object> listerModePaiementParEtat(@PathVariable("etat") String etat) {
        try{
            return new ResponseEntity<Object>(modeService.listerModePaiementParEtat(etat),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(path = "/ajouterModePaiement",method = RequestMethod.POST)
    public ResponseEntity<Object> ajouterModePaiement(@RequestBody ModePaiement ModePaiement) {
        try{
            return new ResponseEntity<Object>(modeService.ajouterModePaiement(ModePaiement),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    
    }

    @RequestMapping(path="/modifierModePaiement",method = RequestMethod.PUT)
    public ResponseEntity<Object> modifierModePaiement(@RequestBody ModePaiement ModePaiement) {
        try{
            return new ResponseEntity<Object>(modeService.modifierModePaiement(ModePaiement),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/consulterModePaiement/{code}", method = RequestMethod.GET)
    public ResponseEntity<Object> consulterModePaiement(@PathVariable("code") Long code) {
        try{
            return new ResponseEntity<Object>(modeService.consulterModePaiement(code),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/desactiverMode/{code}", method = RequestMethod.PUT)
    public ResponseEntity<Object> desactiverMode(@PathVariable("code") Long code) {
        try{
            return new ResponseEntity<Object>(modeService.desactiverModePaiementById(code),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

    @RequestMapping(value = "/activerMode/{code}", method = RequestMethod.PUT)
    public ResponseEntity<Object> activerMode(@PathVariable("code") Long code) {
        try{
            return new ResponseEntity<Object>(modeService.activerModePaiementById(code),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
      
    }
}