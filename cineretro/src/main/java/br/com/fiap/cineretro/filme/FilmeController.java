package br.com.fiap.cineretro.filme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;

@Controller 
@RequestMapping("/filme")
public class FilmeController {

    @Autowired
    FilmeService service;

    @GetMapping
    public String index(Model model, @AuthenticationPrincipal OAuth2User user){
        model.addAttribute("username", user.getAttribute("name"));
        model.addAttribute("avatar_url", user.getAttribute("avatar_url"));
        model.addAttribute("tasks", service.findAll());
        return "filme/index";
    }
    
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirect){
        if (service.delete(id)){
            redirect.addFlashAttribute("success", "Filme apagado com sucesso");
        }else{
            redirect.addFlashAttribute("error", "Filme não encontrado");
        }
        return "redirect:/filme";
    }

    @GetMapping("new")
    public String form(Task task){
        return "filme/form";
    }

    @PostMapping
    public String create(@Valid Task task, BindingResult binding, RedirectAttributes redirect){
        if (binding.hasErrors()) return "/task/form";

        service.save(task);
        redirect.addFlashAttribute("success", "Tarefa cadastrada com sucesso");
        return "redirect:/task";
    }
    
}
