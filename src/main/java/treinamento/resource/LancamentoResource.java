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

import treinamento.model.Lancamento;
import treinamento.model.Pessoa;
import treinamento.service.LancamentoService;
import treinamento.service.PessoaService;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoResource {

	@Autowired
	private LancamentoService lancamentoService;

	@GetMapping
	public List<Lancamento> listar() {
		return lancamentoService.listar();
	}

	@PostMapping
	public ResponseEntity<Lancamento> adicionarCategoria(@RequestBody Lancamento lancamento) {
		Lancamento lancamentoSalvo = this.lancamentoService.adicionar(lancamento);
		return ResponseEntity.status(HttpStatus.CREATED).body(lancamentoSalvo);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Lancamento> buscarPorId(@PathVariable("codigo") Long codigo) {
		Optional<Lancamento> lancamentoBuscadoAux = this.lancamentoService.buscarPorId(codigo);
		if (lancamentoBuscadoAux.isPresent()) {
			Lancamento categoriaBuscada = lancamentoBuscadoAux.get();
			return ResponseEntity.status(HttpStatus.OK).body(categoriaBuscada);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@DeleteMapping("/{codigo}")
	public ResponseEntity<Pessoa> deletarCategoria(@PathVariable("codigo") Long codigo) {
		this.lancamentoService.deletar(codigo);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

//	@PutMapping("/{codigo}")
//	public ResponseEntity<Lancamento> atualizarCategoria(@PathVariable("codigo") Long codigo, @RequestBody Lancamento pessoa) {
//		Lancamento pessoaAtualizada = this.lancamentoService.atualiza(codigo, pessoa);
//		return ResponseEntity.status(HttpStatus.OK).body(pessoaAtualizada);
//
//	}

}