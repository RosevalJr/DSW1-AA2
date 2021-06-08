package br.ufscar.dc.dsw.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@SuppressWarnings("serial")
@Entity
@Table(name = "Vaga")
public class Vaga extends AbstractEntity<Long>{
	
	@NotBlank(message = "{NotBlank.vaga.descricao}")
	@Column(nullable = false, length = 256)
	private String descricao;
	
    @NotBlank(message = "{NotBlank.vaga.datalimite}")
	@Column(nullable = false, length = 19)
	private String dataLimite;
    
	@NotNull(message = "{NotNull.vaga.remuneracao}")
	@Column(nullable = false, columnDefinition = "DECIMAL(8,2) DEFAULT 0.0")
	private Double remuneracao;
	
	@NotNull(message = "{NotNull.vaga.empresa}")
	@ManyToOne
	@JoinColumn(name = "empresa_id")
	private Empresa empresa;
	
	@OneToMany(mappedBy = "vaga")
	private List<Candidatura> candidaturas;
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDatalimite() {
		return dataLimite;
	}

	public void setDatalimite(String dataLimite) {
		this.dataLimite = dataLimite;
	}
	
	public Double getRemuneracao() {
		return remuneracao;
	}

	public void setRemuneracao(Double remuneracao) {
		this.remuneracao = remuneracao;
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	public List<Candidatura> getCandidaturas(){
		return candidaturas;
	}
	
	public void setCandidaturas(List<Candidatura> candidaturas) {
		this.candidaturas = candidaturas;
	}
}
