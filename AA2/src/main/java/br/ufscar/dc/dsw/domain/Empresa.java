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
@Table(name = "Empresa")
public class Empresa extends AbstractEntity<Long>{
	
	@NotBlank(message = "{NotBlank.empresa.cnpj}")
	@Size(min = 18, max = 18, message = "{Size.empresa.cnpj}")
	@Column(nullable = false, unique = true, length = 60)
	private String CNPJ;
	
	@NotBlank(message = "{NotBlank.empresa.cidade}")
	@Column(nullable = false, length = 60)
	private String cidade;
	
	@NotBlank(message = "{NotBlank.empresa.descricao}")
	@Column(nullable = false, length = 256)
	private String descricao;
    
	@NotNull(message = "{NotNull.profissional.usuario}")
	@OneToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	@OneToMany(mappedBy = "empresa")
	private List<Vaga> vagas;
	
	public String getCnpj() {
		return CNPJ;
	}

	public void setCnpj(String CNPJ) {
		this.CNPJ = CNPJ;
	}
	
	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public List<Vaga> getVagas() {
		return vagas;
	}

	public void setVagas(List<Vaga> vagas) {
		this.vagas = vagas;
	}
}
