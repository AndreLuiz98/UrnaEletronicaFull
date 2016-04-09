package bean;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.CandidatoDAO;
import dao.VotoDAO;
import entidade.Apuracao;
import entidade.Candidato;

@ManagedBean(name = "ApuracaoBean")
@SessionScoped
public class ApuracaoBean {

	Apuracao apuracao;

	public ApuracaoBean(){

		this.apuracao = new Apuracao();
	}

	public void ApuracaoFinal() throws IOException{

		CandidatoDAO candidatoDAO = new CandidatoDAO();
		VotoDAO votoDAO = new VotoDAO();

		apuracao.setQuantVotos(votoDAO.getAll().size());

		List<Candidato> candidatos = candidatoDAO.getAll();

		for(Candidato candidato : candidatos){

			switch (candidato.getCargo()) {

			case "Prefeito":

				candidato.setNumeroVotos(votoDAO.getVotosCandidato(candidato.getNumero(),candidato.getCargo()));

				if(apuracao.getMayorVoted()== null)
					apuracao.setMayorVoted(candidato);

				else if(apuracao.getMayorVoted().getNumeroVotos() < candidato.getNumeroVotos()){
					apuracao.setElectedMayor(candidato);
				}

				break;

			case "Governador":

				candidato.setNumeroVotos(votoDAO.getVotosCandidato(candidato.getNumero(),candidato.getCargo()));

				if(apuracao.getGovernorVoted()== null)
					apuracao.setElectedGovernor(candidato);

				else if(apuracao.getElectedGovernor().getNumeroVotos() < candidato.getNumeroVotos()){
					apuracao.setElectedGovernor(candidato);

				}

				break;

			case "Presidente":

				candidato.setNumeroVotos(votoDAO.getVotosCandidato(candidato.getNumero(),candidato.getCargo()));

				if(apuracao.getPresidentVoted()== null)
					apuracao.setElectedPresident(candidato);

				else if(apuracao.getPresidentVoted().getNumeroVotos() < candidato.getNumeroVotos()){
					apuracao.setElectedPresident(candidato);

				}

				break;

			default:

				break;
			}

		}
		
		apuracao.setElectedMayor(apuracao.getGovernorVoted());
		apuracao.setElectedGovernor(apuracao.getGovernorVoted());
		apuracao.setElectedPresident(apuracao.getPresidentVoted());
		apuracao.setQuantBrancos(votoDAO.getVotosEmBranco());
		apuracao.setQuantVotos(votoDAO.getAll().size());
		
		FacesContext.getCurrentInstance().getExternalContext().redirect("apuracaoFinal.xhtml"); 	

	}

	public Apuracao getApuracao() {
		return apuracao;
	}

	public void setApuracao(Apuracao apuracao) {
		this.apuracao = apuracao;
	}

}
