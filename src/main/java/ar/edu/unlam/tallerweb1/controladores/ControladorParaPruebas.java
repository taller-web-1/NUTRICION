package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Controller
public class ControladorParaPruebas {

//query Parameter
//ejemplo: /saludarUsuario
	@RequestMapping (path="/saludarUsuario")
	public ModelAndView saludarUsuario(){
		ModelMap model=new ModelMap();
		Usuario miUsuario = new Usuario();
		miUsuario.setEmail("micorreo@gmail.com");
		miUsuario.setRol("admin");
		model.put("saludo", "Hola Usuario");
		model.put("pirulo", miUsuario);
		return new ModelAndView("saludo",model);
	}
	
//query Parameter 2 variables
//ejemplo:   /saludar?nombre=Ariel&apellido=Martin
//NOTA: si solo se pone /saludar dara error y pedira las variables	
	@RequestMapping("/saludar")
	public ModelAndView irMostrarNombreURL( @RequestParam("nombre")String nombre,
											@RequestParam("apellido")String apellido){
				
		ModelMap modelo = new ModelMap();
		modelo.put("key1",nombre);
		modelo.put("key2", apellido);
				
		return new ModelAndView("saludo2", modelo);		
	}
	

	
//PathVariable
//ejemplo:  /saludar/Martin
	@RequestMapping("/saludar/{nombre}/{apellido}")
	public ModelAndView irMostrarNombrePorURL(	@PathVariable String nombre,
											 	@PathVariable String apellido )
	{
					
		ModelMap modelo = new ModelMap();
		modelo.put("key3",nombre);
		modelo.put("key4",apellido);
					
		return new ModelAndView("saludo2", modelo);		
	}	
	
}
