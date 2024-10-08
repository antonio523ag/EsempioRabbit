package org.elis.chat.service.impl;

import java.util.List;

import org.elis.chat.model.Utente;
import org.elis.chat.repository.UtenteRepository;
import org.elis.chat.service.def.UtenteService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UtenteServiceImpl implements UtenteService {
	private final UtenteRepository repo;

	@Override
	public Utente registra(Utente u) {
		if(repo.findByUsername(u.getUsername()).isPresent())throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"username gia presente");
		u.setId(0);
		return repo.save(u);
		
	}

	@Override
	public Utente login(String email, String password) {
		return repo.findByUsernameAndPassword(email, password)
				.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@Override
	public Utente findById(long id) {
		return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@Override
	public List<Utente> findAll() {
		return repo.findAll();
	}

	@Override
	public Utente findByUsername(String username) {
		return repo.findByUsername(username).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
}
