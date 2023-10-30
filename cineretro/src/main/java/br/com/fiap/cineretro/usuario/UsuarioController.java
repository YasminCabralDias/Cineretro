package br.com.fiap.cineretro.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuarioController {

    @Autowired
    UsuarioRepository repository;

    @GetMapping("/usuarios")
    public String usersPage(Model model){
        model.addAttribute("usuarios", repository.findAll());
        return "auth/usuarios";
    }


    @GetMapping("/login")
    public String loginPage(){
        return "auth/login";
    }
    @GetMapping("/logout")
    public String logoutPage(){
        return "auth/logout";
    }
    
}
