package com.backend.caisse.RestController;

import com.backend.caisse.service.ClientService;

import org.springframework.beans.factory.annotation.Autowired;

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
@RequestMapping("/client")
@CrossOrigin(origins = "*")
public class ClientRestController {

    @Autowired
    ClientService clientService;

    @RequestMapping(value = "/refClient/{refCli}", method = RequestMethod.GET)
    public ResponseEntity<Object> chercherClient(@PathVariable("refCli") Long refCli) {
        try {
            return new ResponseEntity<Object>(clientService.chercherClient(refCli), HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
