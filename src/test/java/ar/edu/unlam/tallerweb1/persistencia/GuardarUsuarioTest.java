package ar.edu.unlam.tallerweb1.persistencia;

import org.hibernate.Session;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import static org.assertj.core.api.Assertions.assertThat;

public class GuardarUsuarioTest extends SpringTest{

	@Test
	@Transactional @Rollback(true)
	public void GuardarUsuarioEnBD(){
//		creamos la session
		Session session;
		session=getSession();
		
//		Preparar: creamos un usuario
		Usuario ariel = new Usuario();
		ariel.setEmail("ariel_martin80@hotmail.com");
		ariel.setPassword("1234");
		ariel.setRol("admin");
		
//		Actuar: Guardamos el Usuario en BD
		session.save(ariel);
		
//		Verificar: realisamos el assert
		Usuario buscado = session.get(Usuario.class,ariel.getId());
		assertThat(buscado).isNotNull();
		}
	
}
