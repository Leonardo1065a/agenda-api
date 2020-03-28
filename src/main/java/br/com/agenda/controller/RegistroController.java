package br.com.agenda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.agenda.business.RegistroBusiness;
import br.com.agenda.model.Registro;

@RestController
@RequestMapping(value = "registros")
@CrossOrigin
public class RegistroController {
	
	private @Autowired RegistroBusiness business;
	
	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<List<Registro>> list(){
		return ResponseEntity.ok(this.business.lista());
	}
	
	@GetMapping(value = "{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<Registro> findById(@PathVariable("id") Long id){
		return ResponseEntity.ok(this.business.findById(id));
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Registro> save(@RequestBody Registro registro) throws Exception{
		return ResponseEntity.ok(this.business.save(registro));
	}
	
	@PutMapping
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<Registro> update(@RequestBody Registro registro) throws Exception{
		return ResponseEntity.ok(this.business.update(registro));	
	}
	
	@DeleteMapping(value = "{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		this.business.deleteById(id);
	}

}
