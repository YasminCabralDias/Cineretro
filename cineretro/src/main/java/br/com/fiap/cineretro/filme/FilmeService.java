package br.com.fiap.cineretro.filme;

import org.springframework.beans.factory.annotation.Autowired;
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

    public void save(Filme filme) {
        repository.save(filme);
    }
    
}