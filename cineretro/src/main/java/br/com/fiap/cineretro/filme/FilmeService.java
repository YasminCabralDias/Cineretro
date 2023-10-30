package br.com.fiap.cineretro.filme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class FilmeService {
    
   @Autowired
    FilmeRepository repository;

    public List<Filme> findAll(){
        return repository.findAll();
    }

    public boolean delete(Long id) {
        var filme = repository.findById(id);
        if(filme.isEmpty()) return false;

        repository.deleteById(id);
        return true;
    }

   
    
    public void decrement(Long id) {
        var optional = repository.findById(id);

        if (optional.isEmpty())
        throw new RuntimeException("filme não encontrado");

        var filme = optional.get();


        repository.save(filme);
    }

    public void increment(Long id) {
        var optional = repository.findById(id);
        if (optional.isEmpty())
        throw new RuntimeException("filme não encontrado");
    }

     public void dropTask(Long id, OAuth2User usuario) {
        var optional = repository.findById(id);

        if (optional.isEmpty())
            throw new RuntimeException("filme não encontrado");

        var filme = optional.get();

        if (filme.getUsuario() == null)
            throw new RuntimeException("filme não atribuído");


        filme.setUsuario(null);

        repository.save(filme);
    }

}
