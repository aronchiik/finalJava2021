package kz.iitu.Service;

import kz.iitu.Model.Client;
import kz.iitu.Model.Movie;
import kz.iitu.Repository.ClientRepository;
import kz.iitu.WEB.DTO.ClientRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ClientServiceImp implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public ClientServiceImp(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client save(ClientRegistrationDto registrationDto){
        Client client = new Client(registrationDto.getNick(),
                registrationDto.getLogin(), registrationDto.getPassword());
        return clientRepository.save(client);
    }

}
