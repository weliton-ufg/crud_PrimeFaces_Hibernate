package com.weliton.Controle;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.weliton.Dao.PessoaDao;
import com.weliton.Modelo.Pessoa;
import com.weliton.Util.FacesUtil;

@Named
@ViewScoped
public class NovoContatoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private Pessoa pessoa;
	@Inject
	private PessoaDao pessoaDao;

	public NovoContatoBean() {
		Limpar();
	}

	public void Salvar() {
		try {
			pessoa = pessoaDao.adicionar(pessoa);
			FacesUtil.addInfoMessage("Contato salvo com Sucesso!");
		} catch (Exception e) {
			FacesUtil.addErroMessage("Erro ao salvar contato");
		}

		Limpar();
	}

	public boolean isEditando() {
		return pessoa.getId() != null;
	}

	public void Limpar() {
		pessoa = new Pessoa();
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
