package com.backend.caisse.service;

import java.util.List;

import com.backend.caisse.entities.Agent;

public interface AgentService {
    
    Agent AjouterAgent(Agent agt);

    Agent ModifierAgent(Agent agt);

    Agent ActiverAgent(long matricule);

    Agent DesactiverAgent(long matricule);

    Agent ConsulterAgent(long matricule);

    List<Agent> ListerAgents();

}