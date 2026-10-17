package biblioteca.biblioteca.Service;

import biblioteca.biblioteca.Dto.LivroPostPutDto;
import biblioteca.biblioteca.Dto.LivroResponseDto;

import java.util.List;

public interface LivroCrudService {

    AutorResponseDto criarLivro(LivroPostPutDto livroPostPutDto);

    List<AutorResponseDto> buscarTodosLivros();

    AutorResponseDto buscarLivro(Long id);

    AutorResponseDto atualizarLivro(Long id, LivroPostPutDto livroPostPutDto);

    void removerLivro(Long id);
}
