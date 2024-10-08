package org.elis.chat.repository;

import java.util.Optional;

import org.elis.chat.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository extends JpaRepository<Utente, Long> {
	public Optional<Utente> findByUsernameAndPassword(String username,String password);
	public Optional<Utente> findByUsername(String username);
	
}
