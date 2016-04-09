package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="tb_eleitor")
@NamedQuery(name="Eleitor.getAll", query=" from Eleitor")
public class Eleitor extends Pessoa{
	
	@Column(name="secao_eleitor")
	private String secao;

	public String getSecao() {
		return secao;
	}

	public void setSecao(String secao) {
		this.secao = secao;
	}
	
}
