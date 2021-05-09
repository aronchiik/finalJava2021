package kz.iitu.Service;

import kz.iitu.Model.Client;
import kz.iitu.Model.Movie;
import kz.iitu.Model.Role;
import kz.iitu.Repository.ClientRepository;
import kz.iitu.WEB.DTO.ClientRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class ClientServiceImp implements ClientService {


    private ClientRepository clientRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public ClientServiceImp(ClientRepository clientRepository) {
        super();
        this.clientRepository = clientRepository;
    }

    @Override
    public Client save(ClientRegistrationDto registrationDto){
        Client client = new Client(registrationDto.getNick(),
                registrationDto.getLogin(), bCryptPasswordEncoder.encode(registrationDto.getPassword()), Arrays.asList(new Role("ROLE_USER")));
        return clientRepository.save(client);
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Client client = clientRepository.findClientByLogin(login);
        if(client == null) {
            throw new UsernameNotFoundException("Invalid clientName or password.");
        }
        return new org.springframework.security.core.userdetails.User(client.getLogin(),client.getPassword(), mapRolesToAuthorities(client.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

}
