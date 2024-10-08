package org.elis.chat.service.def;

import java.util.List;

import org.elis.chat.model.Chat;
import org.elis.chat.model.Utente;

public interface ChatService {
	List<Chat> getAllByUsername(String username);
	Chat getByUsernameAndAltroNome(String username,String secondoUsername);
	void creaChat(Utente utenteUno, Utente utenteDue);
	Chat salva(Chat c);
}
