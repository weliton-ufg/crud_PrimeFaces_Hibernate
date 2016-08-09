package com.weliton.View;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.weliton.Dao.PessoaDao;
import com.weliton.Modelo.Pessoa;
import com.weliton.Util.FacesUtil;



@Named
@RequestScoped
public class ContatoBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Inject
	private Pessoa pessoa;
	@Inject
	private PessoaDao pessoaDao;
	private List<Pessoa> pessoas=new ArrayList<>();
	
	public ContatoBean() {
		Limpar();
	}

	public void Salvar(){
		System.out.println("nome: "+pessoa.getNome());
		pessoa=pessoaDao.adicionar(pessoa);
		
		FacesUtil.addInfoNessage("Contato salvo com Sucesso!");
		Limpar();
		//buscarContatos();
	}
	
	public void buscarContatos(){
		pessoas=pessoaDao.buscarContatos();
	}
	
	public void buscarPorId(){
		//pessoaDao.buscarPorId(pessoa);
	}
	
	public void Limpar(){
		pessoa=new Pessoa();
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
}
