package org.elis.chat.repository;

import java.util.List;
import java.util.Optional;

import org.elis.chat.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ChatRepository extends JpaRepository<Chat, Long> {
	@Query("select c from Chat c where c.utenteUno.id= :id or c.utenteDue.id= :id")
	List<Chat> findAllByIdUtente(long id);
	
	@Query("select c from Chat c where c.utenteUno.username= :username or c.utenteDue.username= :username")
	List<Chat> findAllByUsername(String username);
	
	@Query("select c from Chat c where (c.utenteUno.username= :usernameUno and c.utenteDue.username= :usernameDue) or (c.utenteUno.username= :usernameDue and c.utenteDue.username= :usernameUno)")
	Optional<Chat> findAllByUsername(String usernameUno, String usernameDue);

}
