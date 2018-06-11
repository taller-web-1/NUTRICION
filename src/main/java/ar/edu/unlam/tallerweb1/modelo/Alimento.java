package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

@Entity
public class Alimento {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String tipo;
	private String nombre;
	private int kcal;
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getKcal() {
		return kcal;
	}
	public void setKcal(int kcal) {
		this.kcal = kcal;
	}
	
	
}
