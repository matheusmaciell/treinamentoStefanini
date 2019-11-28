package treinamento.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import treinamento.model.Pessoa;
import treinamento.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource {

	@Autowired
	private PessoaService pessoaService;

	@GetMapping
	public List<Pessoa> listar() {
		return pessoaService.listar();
	}

	@PostMapping
	public ResponseEntity<Pessoa> adicionarCategoria(@RequestBody Pessoa pessoa) {
		Pessoa pessoaSalva = this.pessoaService.adicionar(pessoa);
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Pessoa> buscarPorId(@PathVariable("codigo") Long codigo) {
		Optional<Pessoa> pessoaBuscadaAux = this.pessoaService.buscarPorId(codigo);
		if (pessoaBuscadaAux.isPresent()) {
			Pessoa categoriaBuscada = pessoaBuscadaAux.get();
			return ResponseEntity.status(HttpStatus.OK).body(categoriaBuscada);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@DeleteMapping("/{codigo}")
	public ResponseEntity<Pessoa> deletarCategoria(@PathVariable("codigo") Long codigo) {
		this.pessoaService.deletar(codigo);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Pessoa> atualizarCategoria(@PathVariable("codigo") Long codigo, @RequestBody Pessoa pessoa) {
		Pessoa pessoaAtualizada = this.pessoaService.atualiza(codigo, pessoa);
		return ResponseEntity.status(HttpStatus.OK).body(pessoaAtualizada);

	}

}
