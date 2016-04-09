package back;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="tb_pessoa")
@NamedQuery(name ="Pessoa.getAll", query=" from Pessoa")
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_pessoa")	
	private Integer tituloVotacao;

	@Column(name="nome_pessoa")
	private String nome;

	@Column(name="endereco_pessoa")
	private String endereco;

	@Column(name="cpf_pessoa")
	private String cpf;
	
	@Column(name="tp_pessoa", insertable=false, updatable=false)
    private String tipo;
	
	@Column(name="rg_pessoa")
	private Integer RG;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getTituloVotacao() {
		return tituloVotacao;
	}

	public void setTituloVotacao(Integer tituloVotacao) {
		this.tituloVotacao = tituloVotacao;
	}

	public Integer getRG() {
		return RG;
	}

	public void setRG(Integer rG) {
		RG = rG;
	}
	
}

