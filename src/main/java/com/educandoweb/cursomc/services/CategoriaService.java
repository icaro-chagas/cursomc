package com.educandoweb.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.cursomc.domain.Categoria;
import com.educandoweb.cursomc.repositories.CategoriaRepository;
import com.educandoweb.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null); /* Serve para garantir que o objeto inserido é novo (Caso o id do obj seja diferente de 
		null o método save realiza uma operação de atualização e não inserção) */
		
		return repo.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj); /* O método save serve tanto para inserir quanto atualizar. Quando o id é null 
		tal método insere, e quando o id não é null o método atualiza */
	}
}
