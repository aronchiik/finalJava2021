package kz.iitu.Service;

import kz.iitu.Model.Clients;
import kz.iitu.Repository.ClientRepository;
import kz.iitu.WEB.DTO.ClientRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImp implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public ClientServiceImp(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Clients save(ClientRegistrationDto registrationDto){
        Clients client = new Clients(registrationDto.getNick(),
                registrationDto.getLogin(), registrationDto.getPassword());
        return clientRepository.save(client);
    }

}
