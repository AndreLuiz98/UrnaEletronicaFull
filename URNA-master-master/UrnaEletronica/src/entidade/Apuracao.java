package entidade;

public class Apuracao {

	private int id;

	private int quantVotos, quantBrancos;

	private Candidato mayorVoted, governorVoted, presidentVoted;

	private Candidato electedMayor, electedGovernor, electedPresident;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantVotos() {
		return quantVotos;
	}

	public void setQuantVotos(int quantVotos) {
		this.quantVotos = quantVotos;
	}

	public int getQuantBrancos() {
		return quantBrancos;
	}

	public void setQuantBrancos(int quantBrancos) {
		this.quantBrancos = quantBrancos;
	}

	public Candidato getMayorVoted() {
		return mayorVoted;
	}

	public void setMayorVoted(Candidato mayorVoted) {
		this.mayorVoted = mayorVoted;
	}

	public Candidato getGovernorVoted() {
		return governorVoted;
	}

	public void setGovernorVoted(Candidato governorVoted) {
		this.governorVoted = governorVoted;
	}

	public Candidato getPresidentVoted() {
		return presidentVoted;
	}

	public void setPresidentVoted(Candidato presidentVoted) {
		this.presidentVoted = presidentVoted;
	}

	public Candidato getElectedMayor() {
		return electedMayor;
	}

	public void setElectedMayor(Candidato electedMayor) {
		this.electedMayor = electedMayor;
	}

	public Candidato getElectedGovernor() {
		return electedGovernor;
	}

	public void setElectedGovernor(Candidato electedGovernor) {
		this.electedGovernor = electedGovernor;
	}

	public Candidato getElectedPresident() {
		return electedPresident;
	}

	public void setElectedPresident(Candidato electedPresident) {
		this.electedPresident = electedPresident;
	}

}