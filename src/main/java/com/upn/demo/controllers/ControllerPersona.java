package com.upn.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.upn.demo.interfaces.services.IPersonaService;
import com.upn.demo.models.Persona;

@Controller
@RequestMapping
public class ControllerPersona {

	@Autowired
	private IPersonaService service;
	
	@GetMapping({"/index", "/"})
	public String index() {
		return "index";
	}
	
	@GetMapping("/listar")	
	public String listar(Model model) {
		
		List<Persona> lista= service.listar();
		model.addAttribute("lista_per", lista);
		return "listar";
	}
	
	@GetMapping("/new")	
	public String nuevo(Model model) {
		model.addAttribute("persona", new Persona());
		return "form_persona";
	}
	
	@PostMapping("/save")
	public String save(@Validated Persona p) {
		service.save(p);
		return "redirect:/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") int id,  Model model) {
		
		Optional<Persona> persona = service.listarId(id);
		model.addAttribute("persona", persona);
		return "form_persona_mod";
	}
	
	@GetMapping("/nuevoPedido/{id}")
	public String nuevoPedido(Model model) {
		model.addAttribute("persona", new Persona());
		return "PedidoNuevo";
	}
	
	
	@GetMapping("/new_form")
	public String new_form() {
		return "new_form";
	}
	
	
	@PostMapping("/save_form")
	public String save_form(Model model,@RequestParam("txt_nom") String txt_nom,
			@RequestParam("txt_edad") int txt_edad,
			@RequestParam("cbx_pais") String cbx_pais ) {
		
		model.addAttribute("txt_nom", txt_nom);
		model.addAttribute("txt_edad", txt_edad);
		model.addAttribute("cbx_pais", cbx_pais);
		
		return "imprime_form";
	}
	
	
	
	
	
	
	
}
