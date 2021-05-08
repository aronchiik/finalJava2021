package kz.iitu.Service;

import kz.iitu.Model.Clients;
import kz.iitu.Repository.CientRepository;
import kz.iitu.WEB.DTO.ClientRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ClientServiceImp implements ClientService {

    @Autowired
    private CientRepository cientRepository;

    public ClientServiceImp(CientRepository cientRepository) {
        this.cientRepository = cientRepository;
    }

    @Override
    public Clients save(ClientRegistrationDto registrationDto){
        Clients client = new Clients(registrationDto.getNick(),
                registrationDto.getLogin(), registrationDto.getPassword());
        return cientRepository.save(client);
    }

}
