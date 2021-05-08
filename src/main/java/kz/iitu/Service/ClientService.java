package kz.iitu.Service;


import kz.iitu.Model.Clients;
import kz.iitu.WEB.DTO.ClientRegistrationDto;
import org.springframework.context.annotation.Configuration;

@Configuration
public interface ClientService {
    Clients save(ClientRegistrationDto registrationDto);

}
