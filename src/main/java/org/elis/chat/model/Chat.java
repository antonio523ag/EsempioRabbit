package org.elis.chat.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Data
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"id_utente_uno","id_utente_due"})})
public class Chat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	@JoinColumn(name = "id_utente_uno",nullable = false)
	private Utente utenteUno;
	@ManyToOne
	@JoinColumn(name = "id_utente_due")
	private Utente utenteDue;
	@OneToMany(mappedBy = "chat")
	private List<Messaggio> messaggi;
} 
