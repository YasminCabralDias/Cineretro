package br.com.fiap.cineretro.filme;

import br.com.fiap.cineretro.usuario.Usuario;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity

public class Filme {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{filme.title.blank}")
    private String title;

    @Size(min = 10, message = "{filme.description.size}")
    @Column(name = "description", length = 500)
    private String description;

    @Min(1) @Max(10)
    private Integer rating;

    @ManyToOne
    Usuario usuario;
    
}
