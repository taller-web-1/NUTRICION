package ar.edu.unlam.tallerweb1.persistencia;

import org.hibernate.Session;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.*;

//import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class ManyToManyTest extends SpringTest{

	@Test
	@Transactional
	public void probarGuardarRelacionMuchosAMuchos(){
//		PREPARACION:
//		creamos la session
		Session session;
		session=getSession();

//		instanciamos los objetos
		Empresa empresa1 = new Empresa();
		Empresa empresa2 = new Empresa();
		
		Empleado empleado1 =new Empleado();
		Empleado empleado2 =new Empleado();
		Empleado empleado3 =new Empleado();
		Empleado empleado4 =new Empleado();
		
//		ACCION:
		empleado1.setEmpresa(empresa1);
		empleado2.setEmpresa(empresa1);
		empleado3.setEmpresa(empresa2);
		empleado4.setEmpresa(empresa2);
		
		session.save(empleado1);
		session.save(empleado2);
		session.save(empleado3);
		session.save(empleado4);
		
//		VERIFICACION
		assertEquals(empleado1.getEmpresa(), empresa1);
		assertEquals(empleado3.getEmpresa(), empresa2);
		
	}
	
}
