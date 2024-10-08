package org.elis.chat.mapper;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.elis.chat.dto.MessaggioDTO;
import org.elis.chat.model.Chat;
import org.elis.chat.model.Messaggio;
import org.elis.chat.model.Utente;
import org.springframework.stereotype.Component;

@Component
public class ChatMapper {
	
	public List<String> toUsername(Utente u, List<Chat> chat){
		List<String> utenti=new ArrayList<>();
		for(Chat c:chat) {
			if(c.getUtenteUno().getUsername().equalsIgnoreCase(u.getUsername())) {
				utenti.add(c.getUtenteUno().getUsername());
			}else utenti.add(c.getUtenteDue().getUsername());
		}
		return utenti;
	}
	
	public List<MessaggioDTO> toMessaggioDTOList(Chat c){
		if(c==null||c.getMessaggi()==null)return new ArrayList<>();
		return c.getMessaggi().stream()
				.sorted((c1,c2)->c1.getDataOra().compareTo(c2.getDataOra()))
				.map(m->this.toMessaggioDTO(c.getUtenteUno(),c.getUtenteDue(),m))
				.toList();
				
	}
	
	public MessaggioDTO toMessaggioDTO(Utente u1,Utente u2,Messaggio m) {
		MessaggioDTO mDTO=new MessaggioDTO();
		mDTO.setData(m.getDataOra().format(DateTimeFormatter.ofPattern("EEEE dd MMM yyyy hh:mm:ss")));
		mDTO.setMittente(m.isPrimoUtente()?u1.getUsername():u2.getUsername());
		mDTO.setTesto(m.getTesto());
		return mDTO;
	}
}
