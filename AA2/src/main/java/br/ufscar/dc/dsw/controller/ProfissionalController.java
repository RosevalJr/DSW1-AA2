package br.ufscar.dc.dsw.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufscar.dc.dsw.dao.ICandidaturaDAO;
import br.ufscar.dc.dsw.dao.IProfissionalDAO;
import br.ufscar.dc.dsw.dao.IVagaDAO;
import br.ufscar.dc.dsw.domain.Candidatura;
import br.ufscar.dc.dsw.domain.Profissional;
import br.ufscar.dc.dsw.domain.Vaga;

@Controller
@RequestMapping("/profissionais")
public class ProfissionalController {
	
	@Autowired
	private IProfissionalDAO profissionalDAO;
	
	@Autowired
	private ICandidaturaDAO candidaturaDAO;
	
	@Autowired
	private IVagaDAO vagaDAO;
	
	@GetMapping("/listarCandidaturas")
	public String listarCandidaturas(ModelMap model, Principal principal) {
		
		Profissional profissionalLogado = profissionalDAO.findByUsername(principal.getName());
		
		List<Candidatura> candidaturas = candidaturaDAO.findByProfissional(profissionalLogado);
		
		model.addAttribute("candidaturas", candidaturas);
		model.addAttribute("profissionalLogado", profissionalLogado);
		return "profissional/listaCandidatura";
	}
	
	@GetMapping("/aplicar")
	public String aplicar(ModelMap model, Principal principal) throws java.text.ParseException {
		Profissional profissional = profissionalDAO.findByUsername(principal.getName());
		List<Vaga> todasVagas = vagaDAO.findAll();
		List<Vaga> vagasAbertas =  new ArrayList<Vaga>();
		
		for(int i = 0; i < todasVagas.size(); i++) {
			if(todasVagas.get(i).isAberta())
				if(candidaturaDAO.findByProfissionalAndVaga(profissional, todasVagas.get(i)) == null)
					vagasAbertas.add(todasVagas.get(i));
		}
		
		model.addAttribute("vagas", vagasAbertas);
		return "profissional/aplicar";
	}
	
	@GetMapping("/aplicarVaga/{id}")
	public String aplicarVaga(@PathVariable("id") long id, ModelMap model, Principal principal) {
		
		Profissional profissional = profissionalDAO.findByUsername(principal.getName());
		Vaga vaga = vagaDAO.findById(id);
		
		
		Candidatura candidatura = new Candidatura();
		candidatura.setCurriculo("curriculo.pdf");
		candidatura.setProfissional(profissional);
		candidatura.setVaga(vaga);
		candidatura.setStatus("ABERTO");
		candidaturaDAO.save(candidatura);
		
		return "redirect:/profissionais/aplicar";
	}
	
	@GetMapping("/excluirCandidatura/{id}")
	public String excluirCandidatura(@PathVariable("id") long id, ModelMap model, Principal principal) {
		candidaturaDAO.deleteById(id);
		
		return "redirect:/profissionais/listarCandidaturas";
	}
}
