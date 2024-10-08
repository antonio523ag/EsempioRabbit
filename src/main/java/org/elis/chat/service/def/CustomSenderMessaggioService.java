package org.elis.chat.service.def;

import org.elis.chat.dto.MessaggioDTO;

public interface CustomSenderMessaggioService {
	public void inviaNotifica(MessaggioDTO m,String topic);
	
}
