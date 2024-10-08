package org.elis.chat.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LoginDTO {
	@NotBlank
	@Size(min = 4)
	private String username;
	@NotBlank
	@Size(min = 4)
	private String password;
	
}
