package kz.iitu.Service;


import kz.iitu.Model.Client;
import kz.iitu.WEB.DTO.ClientRegistrationDto;
import org.springframework.context.annotation.Configuration;

@Configuration
public interface ClientService {
    Client save(ClientRegistrationDto registrationDto);

}
