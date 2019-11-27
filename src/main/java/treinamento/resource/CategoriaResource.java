package treinamento.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import treinamento.model.Categoria;
import treinamento.service.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("/listar")
	public List<Categoria> listar(){
		return categoriaService.listar();
	}
	
	@PostMapping("/adicionar")
	public Categoria adicionar(@RequestBody @Valid Categoria categoria) {
		return categoriaService.adicionar(categoria);
	}
}
