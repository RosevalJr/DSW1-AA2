package br.ufscar.dc.dsw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufscar.dc.dsw.dao.IVagaDAO;
import br.ufscar.dc.dsw.domain.Vaga;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/vagas")
public class VagasController {
	
	@Autowired
	private IVagaDAO vagaDAO;
	
	@PostMapping("/listar")
	public String listar(ModelMap model) throws ParseException {
		System.out.println("ENTREI AQUI CARA!");
		
		List<Vaga> todasVagas = vagaDAO.findAll();
		List<Vaga> vagasAbertas =  new ArrayList<Vaga>();
		
		for(int i = 0; i < todasVagas.size(); i++) {
			if(todasVagas.get(i).isAberta())
				vagasAbertas.add(todasVagas.get(i));
		}
		
		model.addAttribute("vagas", vagasAbertas);
		return "vagas/listarTodas";
	}
}
