package back;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import dao.CandidatoDAO;
import entidade.Candidato;

@RequestScoped
@ManagedBean
public class CandidatoBean {

	private Candidato candidato;
	
	public CandidatoBean(){
		
		this.candidato = new Candidato();
		
	}

	public List<Candidato> getCandidatos() {

		return new CandidatoDAO().getAll();	
		
	}

	public void registrar() throws IOException{

		CandidatoDAO candidatoDAO = new CandidatoDAO();
		candidatoDAO.insert(candidato);	
		
		FacesContext.getCurrentInstance().getExternalContext().redirect("identificacaoPessoal.xhtml");

	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

}

