package biblioteca.biblioteca.Service;

import biblioteca.biblioteca.Dto.LivroPostPutDto;
import biblioteca.biblioteca.Dto.LivroResponseDto;
import biblioteca.biblioteca.Model.Livro;
import biblioteca.biblioteca.Repository.LivroRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class LivroCrudPadraoService implements LivroCrudService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    LivroRepository LivroRepository;

    @Override
    public LivroResponseDto criarLivro(LivroPostPutDto LivroPostPutDto) {
        Livro Livro = modelMapper.map(LivroPostPutDto, Livro.class);
        return modelMapper.map(LivroRepository.save(Livro), LivroResponseDto.class);
    }

    @Override
    public List<LivroResponseDto> buscarTodosLivroes() {
        return LivroRepository.findAll()
                .stream()
                .map(Livro -> modelMapper.map(Livro, LivroResponseDto.class))
                .toList();
    }

    @Override
    public LivroResponseDto buscarLivro(Long id) {
        return modelMapper.map(obterLivroExistente(id), LivroResponseDto.class);
    }

    @Override
    public LivroResponseDto atualizarLivro(Long id, LivroPostPutDto LivroPostPutDto) {
        Livro Livro = obterLivroExistente(id);
        Livro.setNomeLivro(LivroPostPutDto.getNomeLivro());
        Livro.setAutor(LivroPostPutDto.getAutor());
        Livro.setAno(LivroPostPutDto.getAno());
        Livro.setEdicao(LivroPostPutDto.getEdicao());
        return modelMapper.map(LivroRepository.save(Livro), LivroResponseDto.class);
    }

    @Override
    public void removerLivro(Long id) {
        // delete(entidade) permite que o cascade da relação remova também os livros do Livro
        LivroRepository.delete(obterLivroExistente(id));
    }

    // id inexistente = 404
    private Livro obterLivroExistente(Long id) {
        return LivroRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado"));
    }
}
