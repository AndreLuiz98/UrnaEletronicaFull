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
		System.out.println("Olha eu aqui");
		CandidatoDAO candidatoDAO = new CandidatoDAO();
		VotoDAO votoDAO = new VotoDAO();

		apuracao.setQuantVotos(votoDAO.getAll().size());

		List<Candidato> candidatos = candidatoDAO.getAllCandidatos();

		for(Candidato candidatoDynamic : candidatos){

			switch (candidatoDynamic.getCargo()) {

			case "Prefeito":

				candidatoDynamic.setNumeroVotos(votoDAO.getVotosCandidato(candidatoDynamic.getNumero(), candidatoDynamic.getCargo()));

				if(apuracao.getMayorVoted() == null){

					apuracao.setMayorVoted(candidatoDynamic);

				}else if(apuracao.getMayorVoted().getNumeroVotos() < candidatoDynamic.getNumeroVotos()){

					apuracao.setElectedMayor(candidatoDynamic);

				}

				System.out.println("Olha eu aqui");
				break;

			case "Governador":

				candidatoDynamic.setNumeroVotos(votoDAO.getVotosCandidato(candidatoDynamic.getNumero(),candidatoDynamic.getCargo()));

				if(apuracao.getGovernorVoted() == null){

					apuracao.setGovernorVoted(candidatoDynamic);

				}else if(apuracao.getGovernorVoted().getNumeroVotos() < candidatoDynamic.getNumeroVotos()){

					apuracao.setElectedGovernor(candidatoDynamic);

				}

				System.out.println("Olha eu aqui");
				break;

			case "Presidente":

				candidatoDynamic.setNumeroVotos(votoDAO.getVotosCandidato(candidatoDynamic.getNumero(),candidatoDynamic.getCargo()));
					
				if(apuracao.getPresidentVoted() == null){

					apuracao.setPresidentVoted(candidatoDynamic);

				}else if(apuracao.getPresidentVoted().getNumeroVotos() < candidatoDynamic.getNumeroVotos()){

					apuracao.setElectedPresident(candidatoDynamic);

				}

				System.out.println("Olha eu aqui");
				break;

			default:

				break;
			}

		}

		apuracao.setElectedMayor(apuracao.getMayorVoted());
		apuracao.setElectedGovernor(apuracao.getGovernorVoted());
		apuracao.setElectedPresident(apuracao.getPresidentVoted());
		apuracao.setQuantBrancos(votoDAO.getVotosEmBranco());
		apuracao.setQuantVotos(votoDAO.getAll().size());

		FacesContext.getCurrentInstance().getExternalContext().redirect("apuracaoFinal.xhtml"); 	
		System.out.println(apuracao.getMayorVoted());
		System.out.println(apuracao.getGovernorVoted());
		System.out.println(apuracao.getPresidentVoted());
		System.out.println("aquiPOSADASJDHS");
	}

	public Apuracao getApuracao() {
		return apuracao;
	}

	public void setApuracao(Apuracao apuracao) {
		this.apuracao = apuracao;
	}

}
