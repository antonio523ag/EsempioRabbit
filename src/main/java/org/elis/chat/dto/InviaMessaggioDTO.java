package org.elis.chat.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class InviaMessaggioDTO {
	@NotBlank
	@Size(min = 4)
	private String usernameDestinatario;
	@NotBlank
	private String testo;
}
