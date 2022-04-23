package com.backend.caisse.serviceImp;

import com.backend.caisse.entities.Client;
import com.backend.caisse.repos.ClientRepository;
import com.backend.caisse.service.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public Client chercherClient(Long refCli) {
        // TODO Auto-generated method stub
        return clientRepository.findByReferenceClient(refCli);
    }
    
}
