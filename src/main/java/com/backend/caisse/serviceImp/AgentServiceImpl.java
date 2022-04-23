package com.backend.caisse.serviceImp;

import java.util.List;

import com.backend.caisse.entities.Agent;
import com.backend.caisse.repos.AgentRepository;
import com.backend.caisse.service.AgentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgentServiceImpl implements AgentService{
    @Autowired
    AgentRepository agentRepository;

    @Override
    public Agent AjouterAgent(Agent agt) {
        return agentRepository.save(agt);
    }

    @Override
    public Agent ModifierAgent(Agent agt) {
        return agentRepository.save(agt);
    }

    @Override
    public Agent ActiverAgent(long matricule) {

        agentRepository.updateEtatActiv(matricule);
        return  agentRepository.findByIdU(matricule);
        
    }

    @Override
    public Agent DesactiverAgent(long matricule) {

        agentRepository.updateEtatDesact(matricule);
        return  agentRepository.findByIdU(matricule);
    }

    @Override
    public Agent ConsulterAgent(long matricule) {
        return agentRepository.findById(matricule).get();
    }

    @Override
    public List<Agent> ListerAgents() {
        return agentRepository.findAll();
    }
}
