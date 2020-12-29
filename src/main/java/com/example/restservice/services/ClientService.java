package com.example.restservice.services;

import com.example.restservice.entities.Client;
import com.example.restservice.repositories.ClientRepository;
import com.example.restservice.services.exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public List<Client> findAll() {
        return repository.findAll();
    }

    public Client findById(Long id) {
        Optional<Client> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Client insert(Client obj) {
        try {
            checkEmailAndCpfInUse(obj);
            return repository.save(obj);
        } catch (EmailInUseException e) {
            throw new EmailInUseException(e.getMessage());
        } catch (CpfInUseException e) {
            throw new CpfInUseException(e.getMessage());
        } catch (Exception e) {
            throw new InvalidClientException(obj);
        }
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new ResourceNotFoundException(id);
        }
    }

    public Client update(Long id, Client obj) {
        try {
            Client entity = repository.getOne(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (Exception e) {
            throw new ResourceNotFoundException(id);
        }

    }

    private void updateData(Client entity, Client obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setCpf(obj.getCpf());
        entity.setBirthDate(obj.getBirthDate());
    }

    public void checkEmailAndCpfInUse(Client obj) {
        List<Client> clientList = repository.findAll();
        for (Client client : clientList) {
            if (client.getEmail().equals(obj.getEmail())) {
                throw new EmailInUseException("Email informado já está em uso");
            }
            if (client.getCpf().equals(obj.getCpf())) {
                throw new CpfInUseException("CPF informado ja está em uso");
            }
        }
    }
}
