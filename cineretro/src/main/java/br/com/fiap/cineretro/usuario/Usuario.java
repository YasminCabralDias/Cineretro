package br.com.fiap.cineretro.usuario;


import org.springframework.security.oauth2.core.user.OAuth2User;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity (name = "githubuser")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Usuario {
    @Id
    Long id;
    String name;
    Integer rating;


    public static Usuario convert(OAuth2User githubuser){
        return new Usuario().builder()
                .id(Long.valueOf(githubuser.getName()))
                .name(githubuser.getAttribute("name"))
                .build();
    }
    
}
