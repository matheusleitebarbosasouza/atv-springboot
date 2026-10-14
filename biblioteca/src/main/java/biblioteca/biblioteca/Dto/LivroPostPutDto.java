package biblioteca.biblioteca.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LivroPostPutDto {
    @JsonProperty("nomeLivro")
    @NotBlank(message = "Nome do livro não pode ser vazio")
    private String nomeAutor;

    @JsonProperty("Ano")
    @NotBlank(message = "Ano do Livro não pode ser vazio")
    private int Ano;

    @JsonProperty("Autor")
    @NotBlank(message = "Autor do Livro não pode ser vazio")
    private Autor Autor;

    @JsonProperty("Edicao")
    @NotBlank(message = "Edicao do Livro não pode ser vazio")
    private String Ediçao;
}
