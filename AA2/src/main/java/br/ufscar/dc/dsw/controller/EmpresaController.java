package br.ufscar.dc.dsw.controller;

import java.security.Principal;
import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufscar.dc.dsw.domain.Vaga;
import br.ufscar.dc.dsw.dao.ICandidaturaDAO;
import br.ufscar.dc.dsw.dao.IEmpresaDAO;
import br.ufscar.dc.dsw.dao.IVagaDAO;
import br.ufscar.dc.dsw.domain.Candidatura;
import br.ufscar.dc.dsw.domain.Empresa;

@Controller
@RequestMapping("/empresas")
public class EmpresaController {
	
	@Autowired
	private IEmpresaDAO empresaDAO;
	
	@Autowired
	private IVagaDAO vagaDAO;
	
	@Autowired
	private ICandidaturaDAO candidaturaDAO;
	
	@GetMapping("/listarVagas")
	public String listarEmpresas(ModelMap model, Principal principal) {
		
		Empresa empresaLogada = empresaDAO.findByUsername(principal.getName());
		
		List<Vaga> vagas = vagaDAO.findByEmpresa(empresaLogada);
		
		for(int i = 0 ; i < vagas.size(); i++) {
			System.out.println(vagas.get(i).getRemuneracao());
		}
		
		model.addAttribute("vagas", vagas);
		model.addAttribute("empresaLogada", empresaLogada);
		return "empresa/listaVaga";
	}
	
	@GetMapping("/cadastrarVagas")
	public String cadastrar(Vaga vaga, Principal principal) {
		Empresa empresaLogada = empresaDAO.findByUsername(principal.getName());
		vaga.setEmpresa(empresaLogada);
		return "empresa/cadastroVaga";
	}
	
	@PostMapping("/salvarVagas")
	public String salvar(@Valid Vaga vaga, BindingResult result, RedirectAttributes attr, Principal principal) throws ParseException {
		
		String[] partesData = vaga.getDatalimite().split("-");
		
		if(partesData.length == 3) {
			String dataCorreta = partesData[2] + "/" + partesData[1] + "/" + partesData[0];
			vaga.setDatalimite(dataCorreta);
		}

		if (result.hasErrors()) {
			return "empresa/cadastroVaga";
		}
		
		vagaDAO.save(vaga);
		
		attr.addFlashAttribute("sucess", "Vaga inserida com sucesso.");
		return "redirect:/empresas/listarVagas";
	}
	
	@GetMapping("/listarCandidaturas/{id}")
	public String editarProfissional(@PathVariable("id") Long id, ModelMap model) {
		Vaga vaga = vagaDAO.findById(id).get();
		
		List<Candidatura> candidaturas = candidaturaDAO.findByVaga(vaga);

		model.addAttribute("candidaturas", candidaturas);
		model.addAttribute("vaga", vaga);
		return "empresa/listaCandidatura";
	}
	
}
