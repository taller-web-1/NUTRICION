package ar.edu.unlam.tallerweb1.persistencia;

import org.hibernate.Session;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class ModificarUsuarioTest extends SpringTest{

	@Test
	@Transactional @Rollback(true)
	public void CambiarDatosUsuarioDeBD(){
//		creamos la session
		Session session;
		session=getSession();
		
//		Preparar: creamos un usuario
		Usuario ariel = new Usuario();
		ariel.setEmail("ariel_martin80@hotmail.com");
		ariel.setPassword("1234");
		ariel.setRol("administrador");	
//		se guarda
		session.save(ariel);
//		guardamos por el id
		Usuario nuevoUsuario = session.get(Usuario.class,ariel.getId());
				
//		Actuar: Cambiar los datos del Usuario en BD
		Usuario usuarioRecuperado = session.get(Usuario.class,nuevoUsuario.getId() );
		usuarioRecuperado.setRol("sin privilegios");
		session.save(usuarioRecuperado);
		Usuario usuarioModificado = session.get(Usuario.class,usuarioRecuperado.getId());

//		comprobar: verificamos que el rol sea el que se cambió
		assertEquals("sin privilegios",usuarioModificado.getRol() );
	}
	
	public void EliminarUsuarioDeBD(){
//		creamos la session
		Session session;
		session=getSession();
		
//		Preparar: creamos un usuario
		Usuario ariel = new Usuario();
		ariel.setEmail("ariel_martin80@hotmail.com");
		ariel.setPassword("1234");
		ariel.setRol("administrador");	

//		se guarda el usuario en BD
		session.save(ariel);
		
//		Eliminamos el Usuario creado de la bd
		session.delete(ariel);
		
//		Comprobamos que no exista el usuario en la bd
		Usuario nuevoUsuario = session.get(Usuario.class,ariel.getId());	
		assertThat(nuevoUsuario).isNull();
			
	}
	
}
