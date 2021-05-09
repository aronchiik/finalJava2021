package kz.iitu.Service;


import kz.iitu.Model.Client;
import kz.iitu.WEB.DTO.ClientRegistrationDto;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public interface ClientService extends UserDetailsService {
    Client save(ClientRegistrationDto registrationDto);

}
