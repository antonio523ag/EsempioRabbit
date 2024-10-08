package org.elis.chat.mapper;

import java.util.ArrayList;
import java.util.List;

import org.elis.chat.dto.LoginDTO;
import org.elis.chat.dto.UtenteDTO;
import org.elis.chat.model.Utente;
import org.springframework.stereotype.Component;

@Component
public class UtenteMapper {
	public UtenteDTO toUtenteDTO(Utente u) {
		UtenteDTO uDTO=new UtenteDTO();
		uDTO.setId(u.getId());
		uDTO.setUsername(u.getUsername());
		return uDTO;
	}
	
	public Utente toUtente(LoginDTO uDTO) {
		Utente u=new Utente();
		u.setPassword(uDTO.getPassword());
		u.setUsername(uDTO.getUsername());
		return u;
	}
	
	public List<String> toUsername(List<Utente> list){
		if(list==null)return new ArrayList<>();
		return list.stream().map(Utente::getUsername).sorted().toList();
	}
	
	
}
