package br.ufscar.dc.dsw.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufscar.dc.dsw.domain.Vaga;
import br.ufscar.dc.dsw.dao.IEmpresaDAO;
import br.ufscar.dc.dsw.dao.IVagaDAO;
import br.ufscar.dc.dsw.domain.Empresa;

@Controller
@RequestMapping("/empresas")
public class EmpresaController {
	
	@Autowired
	private IEmpresaDAO empresaDAO;
	
	@Autowired
	private IVagaDAO vagaDAO;
	
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
	public String cadastrar(Vaga vaga) {;
		return "empresa/cadastroVaga";
	}
	
	@PostMapping("/salvarVagas")
	public String salvar(@Valid Vaga vaga, BindingResult result, RedirectAttributes attr, Principal principal) {
		Empresa empresaLogada = empresaDAO.findByUsername(principal.getName());
		vaga.setEmpresa(empresaLogada);

		if (result.hasErrors()) {
			return "empresa/cadastroVaga";
		}
		
		vagaDAO.save(vaga);
		
		attr.addFlashAttribute("sucess", "Vaga inserida com sucesso.");
		return "redirect:/empresas/listarVagas";
	}
	
}
