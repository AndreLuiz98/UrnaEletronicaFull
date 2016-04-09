package bean;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import dao.EleitorDAO;
import entidade.Eleitor;

@ManagedBean(name = "eleitorBean")
@RequestScoped
public class EleitorBean {

	private Eleitor eleitor;

	public EleitorBean(){

		this.eleitor = new Eleitor();
	}

	public List<Eleitor> getEleitores(){

		return new EleitorDAO().getAll();

	}

	public void inserir() throws IOException{
		
		System.out.println("Aqui");
		
		EleitorDAO eleitorDAO = new EleitorDAO();
		eleitorDAO.insert(eleitor);

		FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml"); 	
	    
	}

	public Eleitor getEleitor() {
		return eleitor;
	}

	public void setEleitor(Eleitor eleitor) {
		this.eleitor = eleitor;
	}

}