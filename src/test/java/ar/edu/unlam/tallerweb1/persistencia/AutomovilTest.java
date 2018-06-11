package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.*;

import static org.junit.Assert.assertEquals;

public class AutomovilTest extends SpringTest {

	@Test @Transactional @Rollback
	@SuppressWarnings("unchecked")
	public void buscarAutosAzules() {
		// PREPARAR
		// creamos la session
		Session session= getSession();

		Automovil autoAzul1 = new Automovil();
		autoAzul1.setColor("azul");
		Automovil autoRojo1 = new Automovil();
		autoRojo1.setColor("rojo");
		Automovil autoAzul2 = new Automovil();
		autoAzul2.setColor("azul");

		session.save(autoAzul1);
		session.save(autoAzul2);
		session.save(autoRojo1);
		
//buscar cuantos autos azules hay
		List<Automovil> resultado = 
				getSession().createCriteria(Automovil.class)
				.add(Restrictions.like("color", "azul"))
				.list();

		assertThat(resultado).hasSize(2);
		
		for(Automovil lista: resultado){
			assertEquals("azul",lista.getColor() );
		}
	}
	
	@Test @Transactional @Rollback
//	@SuppressWarnings("unchecked")
	public void buscarAutoPorPatente(){
		// PREPARAR
		// creamos la session
		Session session;
		session = getSession();

		Automovil auto1 = new Automovil();
		auto1.setPatente("1234");
		Automovil auto2 = new Automovil();
		auto2.setPatente("123e");
		Automovil auto3 = new Automovil();
		auto3.setPatente("ea341sd");
		
		session.save(auto1);
		session.save(auto2);
		session.save(auto3);
		
		Automovil resultado=
		(Automovil) getSession().createCriteria(Automovil.class)
		.add(Restrictions.eq("patente", "1234"))
		.uniqueResult();
		
		assertEquals(resultado.getPatente(),"1234");
	}
	
	@Test @Transactional @Rollback
	@SuppressWarnings("unchecked")
	public void buscarAutoPorNombreDelModelo(){
		// PREPARACION
		// creamos la session
		Session session = getSession();
		
//		instanciamos los objetos
		Modelo modeloFiat = new Modelo("Fiat 600");
		Modelo modeloRenault = new Modelo("Clio");
		Modelo modeloPeugeot = new Modelo("408");
		
		Automovil autoFiat1 = new Automovil(modeloFiat);
		Automovil autoRenault1 = new Automovil(modeloRenault);
		Automovil autoRenault2 = new Automovil(modeloRenault);
		Automovil autoPeugeot1 = new Automovil(modeloPeugeot);
		Automovil autoPeugeot2 = new Automovil(modeloPeugeot);
		Automovil autoPeugeot3 = new Automovil(modeloPeugeot);
		
//		ACCION
		session.save(autoFiat1);
		session.save(autoRenault1);
		session.save(autoRenault2);
		session.save(autoPeugeot1);
		session.save(autoPeugeot2);
		session.save(autoPeugeot3);
		
//		VERIFICACION
		List<Automovil> resultado=
		session.createCriteria(Automovil.class).
		createAlias("modelo", "modeloBuscado").
		add(Restrictions.eq("modeloBuscado.nombre", "Clio")).
		list();

//		modelo Clio deben ser 2
		assertThat(resultado).hasSize(2);
		
		for (Automovil listaDeAutos:resultado){
				assertEquals("Clio",listaDeAutos.getModelo().getNombre() );
			}
		
		}
	
	@Test @Transactional @Rollback
	@SuppressWarnings("unchecked")
	public void buscarAutoPorModelo(){
		// PREPARACION
		// creamos la session
		Session session = getSession();
		
//		instanciamos los objetos
		Modelo modeloFiat = new Modelo("Fiat 600");
		Modelo modeloRenault = new Modelo("Clio");
		Modelo modeloPeugeot = new Modelo("408");
		
		Automovil autoFiat1 = new Automovil(modeloFiat);
		Automovil autoRenault1 = new Automovil(modeloRenault);
		Automovil autoRenault2 = new Automovil(modeloRenault);
		Automovil autoPeugeot1 = new Automovil(modeloPeugeot);
		Automovil autoPeugeot2 = new Automovil(modeloPeugeot);
		Automovil autoPeugeot3 = new Automovil(modeloPeugeot);
		
//		ACCION
		session.save(autoFiat1);
		session.save(autoRenault1);
		session.save(autoRenault2);
		session.save(autoPeugeot1);
		session.save(autoPeugeot2);
		session.save(autoPeugeot3);
		
//		VERIFICACION
		List<Automovil> resultado=
		session.createCriteria(Automovil.class).
//		createAlias("modelo", "modelo").
		add(Restrictions.eq("modelo", modeloFiat)).
		list();
//		modeloFiat debe ser 1
		assertThat(resultado).hasSize(1);
	}
	
	@Test @Transactional @Rollback
	@SuppressWarnings("unchecked")
	public void buscarAutoPorMarca(){
		// PREPARACION
		// creamos la session
		Session session = getSession();
		
//		instanciamos los objetos
		Marca fiat =new Marca("FIAT");
		Marca renault =new Marca("RENAULT");
		Marca peugeot =new Marca("PEUGEOT");
		
		Modelo modeloFiat = new Modelo("Fiat 600");
		modeloFiat.setMarca(fiat);
		Modelo modeloRenault = new Modelo("Renault Clio");
		modeloRenault.setMarca(renault);
		Modelo modeloPeugeot = new Modelo("Peugeot 408");
		modeloPeugeot.setMarca(peugeot);
		
		Automovil autoFiat1 = new Automovil(modeloFiat);
		Automovil autoRenault1 = new Automovil(modeloRenault);
		Automovil autoRenault2 = new Automovil(modeloRenault);
		Automovil autoPeugeot1 = new Automovil(modeloPeugeot);
		Automovil autoPeugeot2 = new Automovil(modeloPeugeot);
		Automovil autoPeugeot3 = new Automovil(modeloPeugeot);
		
//		ACCION
		session.save(autoFiat1);
		session.save(autoRenault1);
		session.save(autoRenault2);
		session.save(autoPeugeot1);
		session.save(autoPeugeot2);
		session.save(autoPeugeot3);
		
//		VERIFICACION
		List<Automovil> resultado=
		session.createCriteria(Automovil.class).
		createAlias("modelo", "aliasDeModelo").
		add(Restrictions.eq("aliasDeModelo.marca", peugeot)).
		list();
//		marca Fiat debe ser 1
		assertThat(resultado).hasSize(3);
		
		for (Automovil lista: resultado){
			assertEquals(peugeot,lista.getModelo().getMarca() );
		}
	}
}