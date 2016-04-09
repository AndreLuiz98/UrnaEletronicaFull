package bean;

import java.util.List;

import dao.PessoaDAO;
import entidade.Pessoa;

public class PessoaBean {

	public static void main(String[] args) {

		List<Pessoa> pessoas = PessoaDAO.getInstance().getAll();

		for (Pessoa pessoa: pessoas) {
			System.out.println(pessoa.getTituloVotacao());
			System.out.println(pessoa.getNome());
		}

	}

}
