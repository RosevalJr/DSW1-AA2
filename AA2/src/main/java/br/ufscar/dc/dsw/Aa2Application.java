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
import br.ufscar.dc.dsw.domain.Profissional;
import br.ufscar.dc.dsw.domain.Usuario;

@SpringBootApplication
public class Aa2Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Aa2Application.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(IUsuarioDAO usuarioDAO, IProfissionalDAO profissionalDAO, IEmpresaDAO empresaDAO, IVagaDAO vagaDAO, ICandidaturaDAO candidaturaDAO) {
		return (args) -> {
			// Populando banco de dados.
			/* INSERT INTO Usuario (name ,username ,password, role, enabled) VALUES("Carlos da Silva", "admin","admin","admin", TRUE);
			INSERT INTO Usuario (name ,username ,password, role, enabled) VALUES("Roseval Junior", "rdmaljr@hotmail.com","123password","user", TRUE);
			INSERT INTO Usuario (name ,username ,password, role, enabled) VALUES("Marcela Ribeiro", "marcela@hotmail.com","1234password","user", TRUE);
			INSERT INTO Usuario (name ,username ,password, role, enabled) VALUES("José da Silva", "jose@estudante.ufscar.br","1235password","user", TRUE);
			INSERT INTO Usuario (name ,username ,password, role, enabled) VALUES("MICROSOFT", "microsoft@hotmail.com","1236password","user", TRUE);
			INSERT INTO Usuario (name ,username ,password, role, enabled) VALUES("PROGRAMAS .INC", "roseval@estudante.ufscar.br","1237password","user", TRUE); */
			
			Usuario u1 = new Usuario();
			u1.setUsername("admin");
			u1.setPassword("admin");
			u1.setName("Carlos da Silva");
			u1.setRole("admin");
			u1.setEnabled(true);
			usuarioDAO.save(u1);
			
			Usuario u2 = new Usuario();
			u2.setUsername("rdmaljr@hotmail.com");
			u2.setPassword("123password");
			u2.setName("Roseval Junior");
			u2.setRole("userProfissional");
			u2.setEnabled(true);
			usuarioDAO.save(u2);
			
			Usuario u3 = new Usuario();
			u3.setUsername("marcela@hotmail.com");
			u3.setPassword("123password");
			u3.setName("Marcela Ribeiro");
			u3.setRole("userProfissional");
			u3.setEnabled(true);
			usuarioDAO.save(u3);
			
			Usuario u4 = new Usuario();
			u4.setUsername("jose@estudante.ufscar.br");
			u4.setPassword("123password");
			u4.setName("José da Silva");
			u4.setRole("userProfissional");
			u4.setEnabled(true);
			usuarioDAO.save(u4);
			
			Usuario u5 = new Usuario();
			u5.setUsername("microsoft@hotmail.com");
			u5.setPassword("123password");
			u5.setName("Microsoft");
			u5.setRole("userEmpresa");
			u5.setEnabled(true);
			usuarioDAO.save(u5);
			
			Usuario u6 = new Usuario();
			u6.setUsername("roseval@estudante.ufscar.br");
			u6.setPassword("123password");
			u6.setName("Programas .Inc");
			u6.setRole("userEmpresa");
			u6.setEnabled(true);
			usuarioDAO.save(u6);
			
			
			/*INSERT INTO Profissional (usuario_id ,CPF ,telefone, sexo, nascimento) VALUES(2, 82128243068, "5539806798860", "m", "2000-06-25");
			INSERT INTO Profissional (usuario_id ,CPF ,telefone, sexo, nascimento) VALUES(3, 44634097052, "5577867134261", "f", "1999-04-15");
			INSERT INTO Profissional (usuario_id ,CPF ,telefone, sexo, nascimento) VALUES(4, 35098455014, "5579768042305", "m", "1995-01-02");*/
			
			/*Profissional p1 = new Profissional();
			p1.setId((long) 2);
			p1.setCPF("82128243068");
			p1.setSexo("m");
			p1.setNascimento("2000-06-25");
			p1.setTelefone("5539806798860");
			profissionalDAO.save(p1);*/
		};
	}

}
