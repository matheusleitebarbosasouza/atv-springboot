package biblioteca.biblioteca.Controller;

import biblioteca.biblioteca.Dto.LivroPostPutDto;
import biblioteca.biblioteca.Dto.LivroResponseDto;
import biblioteca.biblioteca.Service.LivroCrudService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
    value = "/v1/livros",
    produces = MediaType.APPLICATION_JSON_VALUE
)
public class LivroV1Controller {

    private final LivroCrudService livroCrudService;

    public LivroV1Controller(LivroCrudService livroCrudService) {
        this.livroCrudService = livroCrudService;
    }

    @PostMapping
    public ResponseEntity<LivroResponseDto> criarLivro(
            @RequestBody @Valid LivroPostPutDto dto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(livroCrudService.criarLivro(dto));
    }

    @GetMapping
    public ResponseEntity<List<LivroResponseDto>> buscarTodosLivros() {

        return ResponseEntity
                .ok(livroCrudService.buscarTodosLivros());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroResponseDto> buscarLivro(
            @PathVariable Long id) {

        return ResponseEntity
                .ok(livroCrudService.buscarLivro(id));
    }

    @GetMapping("/busca")
    public ResponseEntity<List<LivroResponseDto>> buscarPorIsbnOuTitulo(
            @RequestParam String termo) {

        return ResponseEntity
                .ok(livroCrudService.buscarPorIsbnOuTitulo(termo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroResponseDto> atualizarLivro(
            @PathVariable Long id,
            @RequestBody @Valid LivroPostPutDto dto) {

        return ResponseEntity
                .ok(livroCrudService.atualizarLivro(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerLivro(
            @PathVariable Long id) {

        livroCrudService.removerLivro(id);

        return ResponseEntity
                .noContent()
                .build();
    }
}
