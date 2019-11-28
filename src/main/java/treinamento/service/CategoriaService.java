package treinamento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import treinamento.exception.CategoriaNaoEncontradaException;
import treinamento.model.Categoria;
import treinamento.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public List<Categoria> listar() {
		return categoriaRepository.findAll();
	}

	public Categoria adicionar(Categoria categoria) {
		return categoriaRepository.save(categoria);

	}

	public Optional<Categoria> buscarPorId(Long codigo) {
		Optional<Categoria> categoriaBuscada = categoriaRepository.findById(codigo);
		if (categoriaBuscada.isPresent()) {
			return categoriaBuscada;
		}
		else {
			throw new CategoriaNaoEncontradaException("Categoria não existe");
			
		}
		
	}

	public void deletar(Long codigo) {
		Optional<Categoria> categoriaBuscada = this.buscarPorId(codigo);
		if (categoriaBuscada.isPresent()) {
			categoriaRepository.deleteById(codigo);
		}

	}
	//BeanUtils.copyProperties(source, target, ignoreProperties);

	public Categoria atualiza(Long codigo, Categoria categoria) {
		Optional<Categoria> categoriaBuscadaAux = this.buscarPorId(codigo);
		if (categoriaBuscadaAux.isPresent()) {
			Categoria categoriaBuscada = categoriaBuscadaAux.get();
			BeanUtils.copyProperties(categoria, categoriaBuscada, "codigo");
			categoriaRepository.save(categoriaBuscada);
			return categoriaBuscada;
		}
		
		return null;
	}
}
