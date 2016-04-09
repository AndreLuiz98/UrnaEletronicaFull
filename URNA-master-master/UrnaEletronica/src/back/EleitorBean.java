package bean;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class EleitorBean {

	private Eleitor eleitor;

	public EleitorBean(){

		this.eleitor = new Eleitor();
	}

	public List<Eleitor> getEleitores(){

		return new EleitorDAO().getAll();

	}

	public void registrar()	throws IOException{

		EleitorDAO eleitorDAO = new EleitorDAO();
		eleitorDAO.insert(eleitor);

		FacesContext.getCurrentInstance().getExternalContext().redirect("identificacaoPessoal.xhtml");

	}

	public void ValidacaoEleitor()throws IOException{

		Eleitor eleitorVAlidacao = EleitorDAO.getInstance()
				.getById(eleitor.getTituloVotacao());

		if (eleitorVAlidacao == null){

			System.out.println("Invalido");	

		}else{

			FacesContext.getCurrentInstance().getExternalContext()
			.redirect("cabineVotacao.xhtml");

		}
	}

	public Eleitor getEleitor() {
		return eleitor;
	}

	public void setEleitor(Eleitor eleitor) {
		this.eleitor = eleitor;
	}

}