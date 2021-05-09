package kz.iitu.Controller;

import kz.iitu.Service.ClientService;
import kz.iitu.WEB.DTO.ClientRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class clientRegistrationController {


    private  ClientService clientService;

    public clientRegistrationController(ClientService clientService) {
        this.clientService = clientService;
    }


    @GetMapping()
    public String registrationForm(Model model){
        model.addAttribute("client", new ClientRegistrationDto());
        return "registration";
    }

    @PostMapping
    public String registrClient(@ModelAttribute("client")
                      ClientRegistrationDto clientregistrationDto){
        clientService.save(clientregistrationDto );
        return "redirect:/registration?success";
    }
}
