package br.com.agenda.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.agenda.model.Registro;
import br.com.agenda.repository.RegistroRepository;

@Service
public class RegistroBusiness {

	private @Autowired RegistroRepository repository;
	
	public List<Registro> lista(){
		return this.repository.findAll();
	}
	
	public Registro findById(Long id) {
		Optional<Registro> registro = this.repository.findById(id);
		if(registro != null) {
			Registro reg = registro.get();
			return reg;
		}else {
			return new Registro();
		}
	}
	
	public Registro save(Registro registro) throws Exception {
		try {
		 return this.repository.save(registro);
		}catch (Exception e) {
			throw new Exception("Erro ao salvar");
		}
	}

	
	public Registro update(Registro registro) throws Exception{
		try {
			Registro registroSalvo = this.findById(registro.getId());
			if(!(registroSalvo != null)) {
				throw new Exception("Registro não encontrado para atualizar");
			}
			BeanUtils.copyProperties(registro, registroSalvo, "id");
			return this.repository.save(registroSalvo);
		}catch (Exception e) {
			throw new Exception("Erro ao atualizar o registro");
		}
	}
	
	public void deleteById(Long id) {
		this.repository.deleteById(id);
	}
	
	
}
