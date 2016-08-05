package com.weliton.View;

import java.io.Serializable;

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
	private String nome;
	@Inject
	private Pessoa pessoa;
	@Inject
	private PessoaDao pessoaDao;
	
	
	public ContatoBean() {
		Limpar();
	}

	public void Salvar(){
		pessoa=pessoaDao.adicionar(pessoa);
		
		FacesUtil.addInfoNessage("Contato salvo com Sucesso!");
		Limpar();
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		
		this.nome = nome;
	}
}
