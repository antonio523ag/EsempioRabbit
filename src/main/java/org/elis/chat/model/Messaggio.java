package org.elis.chat.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.Data;

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
	@Column(nullable = false,insertable = false,updatable = false,columnDefinition = "DATETIME default CURRENT_TIMESTAMP")
	private LocalDateTime dataOra;
	private boolean primoUtente;
	@ManyToOne
	@JoinColumn(name = "id_chat")
	private Chat chat;
}
