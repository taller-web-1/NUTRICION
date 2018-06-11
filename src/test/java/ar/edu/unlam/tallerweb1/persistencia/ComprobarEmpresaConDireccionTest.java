package ar.edu.unlam.tallerweb1.persistencia;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.*;

//import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.hibernate.Session;

public class ComprobarEmpresaConDireccionTest extends SpringTest{
	
	@Test
	@Transactional
	@Rollback(true)
	public void probarRelacionOneToOneSinCascada(){
//		PREPARACION:
//		creamos la session
		Session session;
		session=getSession();

//		instanciamos los objetos
		Direccion direccion1=new Direccion();
		direccion1.setCalle("Callao");
		direccion1.setNumero(123);
		
		Empresa empresa1=new Empresa();
		empresa1.setNombre("La Perlita");
		empresa1.setDireccion(direccion1);
				
//		ACCION: 
//		guardamos los objetos en BD
		session.save(direccion1);
		session.save(empresa1);
		
//		salvamos los ids de los objetos guardados para buscarlos luego
		Direccion direccionSalvada=session.get(Direccion.class, direccion1.getId() );
		Empresa empresaSalvada=session.get(Empresa.class, empresa1.getId() );
		
//		VERIFICACION
//		comprovamos que la direccion de la empresa salvada sea un objeto del tipo direccion
		assertEquals(direccionSalvada, empresaSalvada.getDireccion() );
		
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void probarRelacionManyToOneConCascada(){
//		PREPARACION
//		creamos la session
		Session session;
		session=getSession();
		
//		creamos empleados
		Empleado empleado1=new Empleado();
		empleado1.setNombre("Ariel");
		empleado1.setApellido("Martin");
		Empleado empleado2=new Empleado();
		empleado2.setNombre("Ezequiel");
		empleado2.setApellido("Luque Moreno");
//		creamos una direccion
		Direccion direccionEmpresa=new Direccion();
		direccionEmpresa.setCalle("Cristiania");
		direccionEmpresa.setNumero(1234);
//		creamos una empresa
		Empresa laRosadita=new Empresa();
		laRosadita.setNombre("La Rosadita");
		laRosadita.setDireccion(direccionEmpresa);
//		asignamos la empresa a los empleados
		empleado1.setEmpresa(laRosadita);
		empleado2.setEmpresa(laRosadita);

//		ACCION: salvar la empresa
		session.save(laRosadita);
		
//		VERIFICACION
//		comprovamos que la empresa de los empleados sea igual a la instancia de la empresa creada
		assertEquals(empleado1.getEmpresa(), laRosadita);
		assertEquals(empleado2.getEmpresa(), laRosadita);
		
	}

}
