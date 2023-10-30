package br.com.fiap.cineretro.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repository;

    public void addRating(Usuario usuario, Integer rating) {
        var userDb = repository.findById(usuario.getId()).get();
        if (userDb.getRating() == null) userDb.setRating(0);
        userDb.setRating(userDb.getRating() + rating);
        repository.save(userDb);
    }
    
}
