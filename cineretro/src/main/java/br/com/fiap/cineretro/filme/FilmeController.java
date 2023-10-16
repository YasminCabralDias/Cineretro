package br.com.fiap.cineretro.filme;

import org.springframework.beans.factory.annotation.Autowired;
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
    public String index(Model model){
        model.addAttribute("filmes", service.findAll());
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
    public String form(Filme filme){
        return "filme/form";
    }

    @PostMapping
    public String create(@Valid Filme filme, BindingResult binding, RedirectAttributes redirect){
        if (binding.hasErrors()) return "filme/form";

        service.save(filme);
        redirect.addFlashAttribute("success", "Filme cadastrado com sucesso");
        return "redirect:/filme";
    }
    
}
