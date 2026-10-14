package biblioteca.biblioteca.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@Table(name = "tb_autor")
@AllArgsConstructor
@NoArgsConstructor
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @Column(name = "ds_nomeLivro", nullable = false)
    @JsonProperty("nomeLivro")
    private String nomeLivro;

    @Column(name = "ds_Autor", nullable = false)
    @JsonProperty("Autor")
    private String Autor;

    @Column(name = "ds_Ano", nullable = false)
    @JsonProperty("Ano")
    private int Ano;

    @Column(name = "ds_Edicao", nullable = false)
    @JsonProperty("Edicao")
    private String Edicao;
    

}
