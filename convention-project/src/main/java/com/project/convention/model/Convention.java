package com.project.convention.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Convention {

	final int ZERO = 0;
	final int UN = 1;
	final int DEUX = 2;
	final int TROIS = 3;
	final int QUATRE = 4;

	enum Participant {
		UN, DEUX, TROIS, QUATRE
	}

	enum Type {
		universitaire, industrielle_nationale, industrielle
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private Participant participant;
	private Type type;
//	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date date_edition;
//	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date date_signature;
	private String objet;
//	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date date_entre_vigueur;
//	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date date_expiration;

	public Convention() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Convention(int id, Participant participant, Type type, Date date_edition, Date date_signature, String objet,
			Date date_entre_vigueur, Date date_expiration) {
		super();
		this.id = id;
		this.participant = participant;
		this.type = type;
		this.date_edition = date_edition;
		this.date_signature = date_signature;
		this.objet = objet;
		this.date_entre_vigueur = date_entre_vigueur;
		this.date_expiration = date_expiration;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Convention [ id=" + id + ", participant=" + participant + ", type=" + type + ", date_edition=" + date_edition
				+ ", date_signature=" + date_signature + ", objet=" + objet + ", date_entre_vigueur="
				+ date_entre_vigueur + ", date_expiration=" + date_expiration + "]";
	}

	public Participant getParticipant() {
		return participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Date getDate_edition() {
		return date_edition;
	}

	public void setDate_edition(Date date_edition) {
		this.date_edition = date_edition;
	}

	public Date getDate_signature() {
		return date_signature;
	}

	public void setDate_signature(Date date_signature) {
		this.date_signature = date_signature;
	}

	public String getObjet() {
		return objet;
	}

	public void setObjet(String objet) {
		this.objet = objet;
	}

	public Date getDate_entre_vigueur() {
		return date_entre_vigueur;
	}

	public void setDate_entre_vigueur(Date date_entre_vigueur) {
		this.date_entre_vigueur = date_entre_vigueur;
	}

	public Date getDate_expiration() {
		return date_expiration;
	}

	public void setDate_expiration(Date date_expiration) {
		this.date_expiration = date_expiration;
	}

}
