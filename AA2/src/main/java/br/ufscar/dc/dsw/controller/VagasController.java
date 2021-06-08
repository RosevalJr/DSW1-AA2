package br.ufscar.dc.dsw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufscar.dc.dsw.dao.IVagaDAO;

@Controller
@RequestMapping("/vagas")
public class VagasController {
	
	@Autowired
	private IVagaDAO dao;
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("vagas", dao.findAll());
		return "vagas/listarTodas";
	}
}
