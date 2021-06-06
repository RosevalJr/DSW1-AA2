package br.ufscar.dc.dsw.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "Profissional")
public class Profissional extends AbstractEntity<Long>{
	
	@NotBlank(message = "{NotBlank.profissional.cpf}")
	@Size(min = 14, max = 14, message = "{Size.profissional.cpf}")
    @Column(nullable = false, length = 14, unique = true)
    private String CPF;
    
	@NotBlank(message = "{NotBlank.profissional.telefone}")
    @Size(max = 15, message = "{Size.profissional.telefone}")
    @Column(nullable = false, length = 15)
    private String telefone;
    
    @Column(nullable = false, length = 13)
    private String sexo = "Indeterminado";
    
    @NotBlank(message = "{NotBlank.usuario.nascimento}")
	@Column(nullable = false, length = 19)
	private String nascimento;
    
	@NotNull(message = "{NotNull.profissional.usuario}")
	@OneToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	@OneToMany(mappedBy = "profissional")
	private List<Candidatura> candidaturas;
    
	public String getCpf() {
		return CPF;
	}

	public void setCpf(String CPF) {
		this.CPF = CPF;
	}
	
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public List<Candidatura> getCandidaturas(){
		return candidaturas;
	}
	
	public void setCandidaturas(List<Candidatura> candidaturas) {
		this.candidaturas = candidaturas;
	}
}
