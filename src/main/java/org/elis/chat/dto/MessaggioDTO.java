package org.elis.chat.dto;

import lombok.Data;

@Data
public class MessaggioDTO {
	private String mittente;
	private String testo;
	private String data;
}
