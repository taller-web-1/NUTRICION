package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Automovil{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String patente;
	private int año;
	private String color;
	@ManyToOne @Cascade({CascadeType.SAVE_UPDATE})
	private Modelo modelo;
	
	public Automovil() {
		super();
	}
	
	public Automovil(Modelo modelo, String color, int año, String patente) {
		super();
		this.patente = patente;
		this.año = año;
		this.color = color;
		this.modelo = modelo;
	}
	public Automovil(Modelo modelo) {
		super();
		this.modelo = modelo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPatente() {
		return patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}
	public int getAño() {
		return año;
	}
	public void setAño(int año) {
		this.año = año;
	}
	public Modelo getModelo() {
		return modelo;
	}
	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	
	

}
