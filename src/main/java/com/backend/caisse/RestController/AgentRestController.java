package com.backend.caisse.RestController;


import com.backend.caisse.entities.Agent;
import com.backend.caisse.service.AgentService;

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
@RequestMapping("/agent")
@CrossOrigin
public class AgentRestController {

    @Autowired
    AgentService agentService;

    @RequestMapping(value = "/listerAgents",method = RequestMethod.GET)
    public ResponseEntity<Object> listerAgents() {
        try{
            return new ResponseEntity<Object>(agentService.ListerAgents(),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value ="/consulterAgent/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> consulterAgent(@PathVariable("id") Long id) {
        try{
            return new ResponseEntity<Object>( agentService.ConsulterAgent(id),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
     
    }

    @RequestMapping(value="/ajouterAgent",method = RequestMethod.POST)
    public ResponseEntity<Object> ajouterAgent(@RequestBody Agent agent) {
        try{
            return new ResponseEntity<Object>(agentService.AjouterAgent(agent),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value="/modifierAgent",method = RequestMethod.PUT)
    public ResponseEntity<Object> modifierAgent(@RequestBody Agent agent) {
        try{
            return new ResponseEntity<Object>(agentService.ModifierAgent(agent),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

 
    
    @RequestMapping(value = "/desactiverAgent/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> desactiverAgent(@PathVariable("id") Long id) {
        try{
            return new ResponseEntity<Object>(agentService.DesactiverAgent(id),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/activerAgent/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> activerAgent(@PathVariable("id") Long id) {
        
        try{
            return new ResponseEntity<Object>(agentService.ActiverAgent(id),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    
}
