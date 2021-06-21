package br.ufscar.dc.dsw.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufscar.dc.dsw.domain.Profissional;
import br.ufscar.dc.dsw.dao.IEmpresaDAO;
import br.ufscar.dc.dsw.dao.IProfissionalDAO;
import br.ufscar.dc.dsw.domain.Empresa;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private IProfissionalDAO profissionalDAO;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	private IEmpresaDAO empresaDAO;

	@PostMapping("/salvarEmpresas")
	public String salvar(@Valid Empresa empresa, BindingResult result, RedirectAttributes attr) {

		if (result.hasErrors()) {
			return "usuario/cadastroEmpresa";
		}

		System.out.println("password = " + empresa.getPassword());

		empresa.setPassword(encoder.encode(empresa.getPassword()));
		empresaDAO.save(empresa);
		attr.addFlashAttribute("sucess", "Empresa inserida com sucesso.");
		return "redirect:/usuarios/listarEmpresas";
	}

	@GetMapping("/editarEmpresas/{id}")
	public String editarEmpresa(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("empresa", empresaDAO.findById(id).get());
		return "usuario/cadastroEmpresa";
	}

	@PostMapping("/editarEmpresas")
	public String editar(@Valid Empresa empresa, BindingResult result, RedirectAttributes attr) {


		if (result.hasErrors()) {
			return "usuario/cadastroEmpresa";
		}

		empresaDAO.save(empresa);
		attr.addFlashAttribute("sucess", "Empresa editada com sucesso.");
		return "redirect:/usuarios/listarEmpresas";
	}

	@PostMapping("/salvarProfissionais")
	public String salvar(@Valid Profissional profissional, BindingResult result, RedirectAttributes attr) {

		String[] partesData = profissional.getNascimento().split("-");

		if (partesData.length == 3) {
			String dataCorreta = partesData[2] + "/" + partesData[1] + "/" + partesData[0];
			profissional.setNascimento(dataCorreta);
		}

		if (result.hasErrors()) {
			return "usuario/cadastroProfissional";
		}

		System.out.println("password = " + profissional.getPassword());

		profissional.setPassword(encoder.encode(profissional.getPassword()));
		profissionalDAO.save(profissional);
		attr.addFlashAttribute("sucess", "Profissional inserido com sucesso.");
		return "redirect:/usuarios/listarProfissionais";
	}

	@GetMapping("/editarProfissionais/{id}")
	public String editarProfissional(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("profissional", profissionalDAO.findById(id).get());
		return "usuario/cadastroProfissional";
	}

	@PostMapping("/editarProfissionais")
	public String editar(@Valid Profissional profissional, BindingResult result, RedirectAttributes attr) {

		String[] partesData = profissional.getNascimento().split("-");

		if (partesData.length == 3) {
			String dataCorreta = partesData[2] + "/" + partesData[1] + "/" + partesData[0];
			profissional.setNascimento(dataCorreta);
		}
		
		if (result.hasErrors()) {
			return "usuario/cadastroProfissional";
		}

		profissionalDAO.save(profissional);
		attr.addFlashAttribute("sucess", "Profissional editado com sucesso.");
		return "redirect:/usuarios/listarProfissionais";
	}

	@GetMapping("/cadastrarEmpresas")
	public String cadastrar(Empresa empresa) {
		empresa.setRole("userEmpresa");
		return "usuario/cadastroEmpresa";
	}

	@GetMapping("/cadastrarProfissionais")
	public String cadastrar(Profissional profissional) {
		profissional.setRole("userProfissional");
		return "usuario/cadastroProfissional";
	}

	@GetMapping("/listarEmpresas")
	public String listarEmpresas(ModelMap model) {
		model.addAttribute("empresas", empresaDAO.findAll());
		return "usuario/listaEmpresa";
	}

	@GetMapping("/listarProfissionais")
	public String listarProfissionais(ModelMap model) {
		model.addAttribute("profissionais", profissionalDAO.findAll());
		return "usuario/listaProfissional";
	}

	@GetMapping("/excluirEmpresas/{id}")
	public String excluirEmpresas(@PathVariable("id") Long id, ModelMap model) {

		empresaDAO.deleteById(id);
		model.addAttribute("sucess", "Empresa excluída com sucesso.");
		return listarEmpresas(model);
	}

	@GetMapping("/excluirProfissionais/{id}")
	public String excluirProfissionais(@PathVariable("id") Long id, ModelMap model) {

		profissionalDAO.deleteById(id);
		model.addAttribute("sucess", "Profissional excluído com sucesso.");
		return listarProfissionais(model);
	}
}
