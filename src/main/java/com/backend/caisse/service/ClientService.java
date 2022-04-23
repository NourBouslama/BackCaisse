package com.backend.caisse.service;

import com.backend.caisse.entities.Client;

public interface ClientService {
    
    Client chercherClient(Long refCli);
}
