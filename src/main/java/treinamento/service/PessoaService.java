package treinamento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import treinamento.exception.CategoriaNaoEncontradaException;
import treinamento.model.Pessoa;
import treinamento.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	public List<Pessoa> listar() {
		return pessoaRepository.findAll();
	}

	public Pessoa adicionar(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

	public Pessoa atualiza(Long codigo, Pessoa pessoa) {
		Optional<Pessoa> pessoaBuscadaAux = this.buscarPorId(codigo);
		if (pessoaBuscadaAux.isPresent()) {
			Pessoa pessoaBuscada = pessoaBuscadaAux.get();
			BeanUtils.copyProperties(pessoa, pessoaBuscada, "codigo");
			pessoaRepository.save(pessoaBuscada);
			return pessoaBuscada;
		}

		return null;
	}

	public void deletar(Long codigo) {
		Optional<Pessoa> pessoaBuscada = this.buscarPorId(codigo);
		if (pessoaBuscada.isPresent()) {
			pessoaRepository.deleteById(codigo);
		}

	}

	public Optional<Pessoa> buscarPorId(Long codigo) {
		Optional<Pessoa> pessoaBuscada = pessoaRepository.findById(codigo);
		if (pessoaBuscada.isPresent()) {
			return pessoaBuscada;
		} else {
			throw new CategoriaNaoEncontradaException("Pessoa não existe");

		}
	}

}
