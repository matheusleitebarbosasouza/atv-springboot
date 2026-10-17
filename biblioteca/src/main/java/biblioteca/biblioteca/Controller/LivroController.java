@RestController
@RequestMapping(value = "/v1/autores", produces = MediaType.APPLICATION_JSON_VALUE)
public class AutorV1Controller {

    @Autowired
    AutorCrudService autorCrudService;
    
    @PostMapping("")
    public ResponseEntity<LivroResponseDto> criarLivro(
            @RequestBody @Valid LivroPostPutDto LivroPostPutDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(autorCrudService.criarLivro(LivroPostPutDto));
    }


     @GetMapping("")
    public ResponseEntity<List<LivroResponseDto>> buscarTodosLivro() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(autorCrudService.buscarTodosLivro());
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<AutorResponseDto> buscarLivro(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(autorCrudService.buscarLivro(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<LivroResponseDto> atualizarLivro(
            @PathVariable Long id,
            @RequestBody @Valid LivroPostPutDto LivroPostPutDto) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(autorCrudService.atualizarLivro(id, LivroPostPutDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerlivro (@PathVariable Long id) {
        autorCrudService.removerlivro(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
