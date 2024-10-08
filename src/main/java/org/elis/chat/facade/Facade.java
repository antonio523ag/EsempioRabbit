package org.elis.chat.facade;

import java.util.List;

import org.elis.chat.dto.InviaMessaggioDTO;
import org.elis.chat.dto.LoginDTO;
import org.elis.chat.dto.MessaggioDTO;
import org.elis.chat.dto.UtenteDTO;
import org.elis.chat.mapper.ChatMapper;
import org.elis.chat.mapper.UtenteMapper;
import org.elis.chat.model.Chat;
import org.elis.chat.model.Messaggio;
import org.elis.chat.model.Utente;
import org.elis.chat.service.def.ChatService;
import org.elis.chat.service.def.MessaggioService;
import org.elis.chat.service.def.UtenteService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Facade {
	private final UtenteService utenteService;
	private final MessaggioService messaggioService;
	private final ChatService chatService;
	
	private final ChatMapper chatMapper;
	private final UtenteMapper utenteMapper;
	
	public UtenteDTO registrazione(LoginDTO request) {
		Utente u=utenteMapper.toUtente(request);
		u=utenteService.registra(u);
		return utenteMapper.toUtenteDTO(u);
	}

	public UtenteDTO login(LoginDTO request) {
		return utenteMapper.toUtenteDTO(utenteService.login(request.getUsername(), request.getPassword()));
	}

	public void inviaMessaggio(long idUser, InviaMessaggioDTO request) {
		Utente u1=utenteService.findById(idUser);
		Utente u2=utenteService.findByUsername(request.getUsernameDestinatario());
		if(u1.getId()==u2.getId())throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		Chat c=chatService.getByUsernameAndAltroNome(u1.getUsername(), u2.getUsername());
		if(c==null) {
			c=new Chat();
			c.setUtenteDue(u2);
			c.setUtenteUno(u1);
			c=chatService.salva(c);
		}
		Messaggio m=new Messaggio();
		m.setChat(c);
		m.setTesto(request.getTesto());
		m.setPrimoUtente(c.getUtenteUno().getUsername().equals(u1.getUsername()));
		messaggioService.aggiungiMessaggio(m);
	}

	public List<MessaggioDTO> getChat(long id, String username) {
		Utente u= utenteService.findById(id);
		Chat c=chatService.getByUsernameAndAltroNome(u.getUsername(), username);
		return chatMapper.toMessaggioDTOList(c);
	}

	public List<String> getUtenti() {
		return utenteMapper.toUsername(utenteService.findAll());
	}
	
	
}
