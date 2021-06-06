package br.ufscar.dc.dsw;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.ufscar.dc.dsw.dao.ICandidaturaDAO;
import br.ufscar.dc.dsw.dao.IEmpresaDAO;
import br.ufscar.dc.dsw.dao.IProfissionalDAO;
import br.ufscar.dc.dsw.dao.IUsuarioDAO;
import br.ufscar.dc.dsw.dao.IVagaDAO;
import br.ufscar.dc.dsw.domain.Usuario;

@SpringBootApplication
public class Aa2Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Aa2Application.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(IUsuarioDAO usuarioDAO, IProfissionalDAO profissionalDAO, IEmpresaDAO empresaDAO, IVagaDAO vagaDAO, ICandidaturaDAO candidaturaDAO) {
		return (args) -> {
			/*Usuario u1 = new Usuario();
			u1.setUsername("adminaaa");
			u1.setPassword("adminaaa");
			u1.setName("Administrador");
			u1.setRole("ROLE_ADMIN");
			u1.setEnabled(true);
			usuarioDAO.save(u1);
			
			Usuario u2 = new Usuario();
			u2.setUsername("beltrano");
			u2.setPassword("123aaaaa");
			u2.setName("Beltrano Andrade");
			u2.setRole("ROLE_USER");
			u2.setEnabled(true);
			usuarioDAO.save(u2);
			
			Usuario u3 = new Usuario();
			u3.setUsername("fulanoaa");
			u2.setPassword("123aaaaa");
			u3.setName("Fulano Silva");
			u3.setRole("ROLE_USER");
			u3.setEnabled(true);
			usuarioDAO.save(u3);*/
		};
	}

}
