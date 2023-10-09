package br.com.fiap.cineretro.filme;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    @NotBlank(message = "campo título é obrigatório")
    private String title;

    @Size(min = 10, message = "descrição deve ter pelo menos 20 caracteres")
    private String description;

    @Min(1) @Max(10)
    private Integer rating;
    
}
