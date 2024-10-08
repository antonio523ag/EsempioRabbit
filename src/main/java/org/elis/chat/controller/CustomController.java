package org.elis.chat.controller;

import java.util.List;

import org.elis.chat.dto.InviaMessaggioDTO;
import org.elis.chat.dto.LoginDTO;
import org.elis.chat.dto.MessaggioDTO;
import org.elis.chat.dto.UtenteDTO;
import org.elis.chat.facade.Facade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CustomController {
	private final Facade facade;
	
	@PostMapping("/utente/registra")
	public ResponseEntity<UtenteDTO> registrazione(@Valid @RequestBody  LoginDTO request){
		UtenteDTO response=facade.registrazione(request);
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/utente/login")
	public ResponseEntity<UtenteDTO> login(@Valid @RequestBody LoginDTO request){
		UtenteDTO response=facade.login(request);
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/messaggio/invia")
	public ResponseEntity<Void> inviaMessaggio(@RequestHeader("User")long idUser,@Valid @RequestBody InviaMessaggioDTO request){
		facade.inviaMessaggio(idUser,request);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/chat/{username}")
	public ResponseEntity<List<MessaggioDTO>> getChat(@RequestHeader("User")long id,@PathVariable String username){
		List<MessaggioDTO> response=facade.getChat(id,username);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/utente/getAll")
	public ResponseEntity<List<String>> getUtenti(){
		List<String> response=facade.getUtenti();
		return ResponseEntity.ok(response);
	}
	
	
}
