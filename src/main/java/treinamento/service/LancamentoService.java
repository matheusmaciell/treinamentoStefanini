package treinamento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import treinamento.exception.CategoriaNaoEncontradaException;
import treinamento.model.Lancamento;
import treinamento.repository.LancamentoRepository;


@Service
public class LancamentoService {

	@Autowired
	private LancamentoRepository lancamentoRepository;

	public List<Lancamento> listar() {
		return lancamentoRepository.findAll();
	}

	public Lancamento adicionar(Lancamento lancamento) {
		return lancamentoRepository.save(lancamento);
	}

	public Optional<Lancamento> atualiza(Long codigo, Lancamento lancamento) {
		Optional<Lancamento> lancamentoBuscadoAux = this.buscarPorId(codigo);
		if (lancamentoBuscadoAux.isPresent()) {
			Lancamento lancamentoBuscado = lancamentoBuscadoAux.get();
			BeanUtils.copyProperties(lancamento, lancamentoBuscado, "codigo");
			lancamentoRepository.save(lancamentoBuscado);
			return lancamentoBuscadoAux;
		}

		return null;
	}

	public void deletar(Long codigo) {
		Optional<Lancamento> pessoaBuscada = this.buscarPorId(codigo);
		if (pessoaBuscada.isPresent()) {
			lancamentoRepository.deleteById(codigo);
		}

	}

	public Optional<Lancamento> buscarPorId(Long codigo) {
		Optional<Lancamento> lancamentoBuscado = lancamentoRepository.findById(codigo);
		if (lancamentoBuscado.isPresent()) {
			return lancamentoBuscado;
		} else {
			throw new CategoriaNaoEncontradaException("Lancamento não existe");

		}
	}

}
