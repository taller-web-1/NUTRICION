package ar.edu.unlam.tallerweb1.controladores;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Controller
public class ControladorUsuarios {

	@RequestMapping(path ="/registrousuario")
	public ModelAndView registrarUsuario()
	{	
		ModelMap modelo = new ModelMap();
		Usuario usuario = new Usuario();
		modelo.put("usuario", usuario);
		
		return new ModelAndView("registrousuario",modelo);
	}
	
	@RequestMapping(path = "/mostrar-usuario-cargado-en-el-form", method = RequestMethod.POST)
	public ModelAndView mostrarUsuario(@ModelAttribute("usuario") Usuario usuario, HttpServletRequest request) 
	{		
		ModelMap modelo = new ModelMap();
		modelo.put("usuario", usuario);
		
		return new ModelAndView("mostrarusuario",modelo);
	}
	
	@RequestMapping(path="/lista-de-usuarios/{cantidad}")
	public ModelAndView listadeusuarios(@PathVariable int cantidad){
		
		ModelMap modelo=new ModelMap();
		
		Usuario usuario1 =new Usuario();
		usuario1.setEmail("ariel@live.com");
		usuario1.setPassword("1234");
		usuario1.setRol("admin"); 
		
		Usuario usuario2 =new Usuario();
		usuario2.setEmail("martin@gmail.com");
		usuario2.setPassword("abcd");
		usuario2.setRol("user");
		
		ArrayList<Usuario> arrayList = new ArrayList<Usuario>();//creamos el objeto lista
		for (int i = 0; i < 5; ++i) {
		    arrayList.add(usuario1);
		    arrayList.add(usuario2);
		}
		
		modelo.put("lista", arrayList);
		modelo.put("cantidad", cantidad);
		
		return new ModelAndView("listarusuarios",modelo);
	}
}
