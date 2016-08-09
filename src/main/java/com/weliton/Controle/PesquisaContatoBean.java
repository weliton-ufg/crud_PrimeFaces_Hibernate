package com.weliton.Controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.weliton.Dao.PessoaDao;
import com.weliton.Modelo.Pessoa;
import com.weliton.Util.FacesUtil;

@Named
@ViewScoped
public class PesquisaContatoBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Inject
	private Pessoa pessoa;
	@Inject
	private PessoaDao pessoaDao;
	private List<Pessoa> pessoas=new ArrayList<>();

	private Pessoa pessoaSelecionada;
	
	public void buscarContatos(){
		pessoas=pessoaDao.buscarContatos();
	}
	
	public void buscarPorId(){
		//pessoaDao.buscarPorId(pessoa);
	}
	public void excluir(){
		try {
	
			pessoaDao.excluir(pessoaSelecionada);
			pessoas.remove(pessoaSelecionada);
			//buscarContatos();
			FacesUtil.addInfoMessage("Contato "+pessoaSelecionada.getNome()+ " Excluído com sucesso!");
			
		} catch (Exception e) {
			FacesUtil.addErroMessage("Erro ao excluir o Contato "+pessoaSelecionada.getNome());
		}
		
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}


	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public Pessoa getPessoaSelecionada() {
		return pessoaSelecionada;
	}

	public void setPessoaSelecionada(Pessoa pessoaSelecionada) {
		this.pessoaSelecionada = pessoaSelecionada;
	}
}
