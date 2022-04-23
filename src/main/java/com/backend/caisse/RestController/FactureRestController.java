package com.backend.caisse.RestController;

import java.util.List;

import com.backend.caisse.entities.Facture;
import com.backend.caisse.service.FactureService;

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
@RequestMapping("/facture")
@CrossOrigin
public class FactureRestController {
    @Autowired
    FactureService factureService;

    @RequestMapping(value = "/refClient/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> chercherFactureParReferenceClient(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<Object>(factureService.ChercherFactureParReferenceClient(id), HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/refContrat/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> chercherFactureParReferenceContrat(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<Object>(factureService.ChercherFactureParReferenceContrat(id), HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/refFacture/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> chercherFactureParReferenceFacture(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<Object>(factureService.ChercherFactureParReferenceFacture(id), HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
