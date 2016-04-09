package bean;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import dao.CandidatoDAO;
import entidade.Candidato;

@RequestScoped
@ManagedBean(name = "candidatoBean")
public class CandidatoBean {

	private Candidato candidato;
	
	public CandidatoBean(){
		
		this.candidato = new Candidato();
		
	}

	public List<Candidato> getCandidatos() {

		return new CandidatoDAO().getAll();	
		
	}

	public void inserir() throws IOException{
		
		System.out.println("Chegou aqui");
		
		CandidatoDAO candidatoDAO = new CandidatoDAO();
		candidatoDAO.insert(candidato);	
		FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml"); 	
		
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

}

