package org.elis.chat.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
public class Messaggio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Lob
	@Column(length = 512)
	private String testo;
	@CreationTimestamp
	@Column(nullable = false,insertable = false,updatable = false,columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
	private LocalDateTime dataOra;
	private boolean primoUtente;
	@ManyToOne
	private Chat chat;
}
