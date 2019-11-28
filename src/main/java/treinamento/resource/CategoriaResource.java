package treinamento.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import treinamento.model.Categoria;
import treinamento.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping
	public List<Categoria> listar() {
		return categoriaService.listar();
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Categoria> buscarPorId(@PathVariable("codigo") Long codigo) {
		Optional<Categoria> categoriaBuscadaAux = this.categoriaService.buscarPorId(codigo);
		if (categoriaBuscadaAux.isPresent()) {
			Categoria categoriaBuscada = categoriaBuscadaAux.get();
			return ResponseEntity.status(HttpStatus.OK).body(categoriaBuscada);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@DeleteMapping("/{codigo}")
	public ResponseEntity<Categoria> deletarCategoria(@PathVariable("codigo") Long codigo) {
		this.categoriaService.deletar(codigo);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Categoria> atualizarCategoria(@PathVariable("codigo") Long codigo,
			@RequestBody Categoria categoria) {
		Categoria categoriaAtualizada = this.categoriaService.atualiza(codigo, categoria);
		return ResponseEntity.status(HttpStatus.OK).body(categoriaAtualizada);

	}

	@PostMapping
	public ResponseEntity<Categoria> adicionarCategoria(@RequestBody @Validated Categoria categoria) {
		Categoria categoriaSalva = this.categoriaService.adicionar(categoria);
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);
	}
}
