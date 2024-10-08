package org.elis.chat.service.impl;

import org.elis.chat.model.Messaggio;
import org.elis.chat.repository.MessaggioRepository;
import org.elis.chat.service.def.MessaggioService;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MessaggioServiceImpl implements MessaggioService {
	private final MessaggioRepository repo;

	@Override
	public void aggiungiMessaggio(Messaggio m) {
		if(m.getChat()!=null) {
			repo.save(m);
		}
	}
}
