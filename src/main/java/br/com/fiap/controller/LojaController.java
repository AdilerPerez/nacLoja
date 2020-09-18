package br.com.fiap.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.fiap.business.LojaBusiness;
import br.com.fiap.exception.ResponseBusinessException;
import br.com.fiap.model.LojaModel;
import br.com.fiap.repository.LojaRepository;

@RestController
@RequestMapping("/loja")
public class LojaController {
	@Autowired
	public LojaRepository repository;
	
	@Autowired
	public LojaBusiness lojaBusiness;
	
	@GetMapping()
	public ResponseEntity<List<LojaModel>> findAll() {

		List<LojaModel> lojas = repository.findAll();
		return ResponseEntity.ok(lojas);
	}

	@GetMapping("/{id}")
	public ResponseEntity<LojaModel> findById(@PathVariable("id") long id) {
		
		LojaModel loja = repository.findById(id).get();
		return ResponseEntity.ok(loja);
	}
	
	@PostMapping()
	public ResponseEntity save(@RequestBody @Valid LojaModel lojaModel) throws ResponseBusinessException {
		
		LojaModel loja = lojaBusiness.applyBusiness(lojaModel);
		
		repository.save(loja);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(loja.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity update(@PathVariable("id") long id, @RequestBody @Valid LojaModel lojaModel) throws ResponseBusinessException {
	
		LojaModel loja = lojaBusiness.applyBusiness(lojaModel);
		
		lojaModel.setId(id);
		
		repository.save(loja);
		
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity deleteById(@PathVariable("id") long id) {
		
		repository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
}
