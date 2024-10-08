package org.elis.chat.service.def;

import java.util.List;

import org.elis.chat.model.Utente;

public interface UtenteService {
	Utente registra(Utente u);
	Utente login(String email,String password);
	Utente findById(long id);
	List<Utente> findAll();
	Utente findByUsername(String username);
}
