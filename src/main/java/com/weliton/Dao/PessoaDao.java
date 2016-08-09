package com.weliton.Dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.weliton.Modelo.Pessoa;

public class PessoaDao implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private EntityManager fabrica;
	
	public Pessoa adicionar(Pessoa pessoa){
		EntityTransaction trx= fabrica.getTransaction(); 
		trx.begin();
			fabrica.merge(pessoa);
		trx.commit();
		
		return pessoa;
		
	}

	@SuppressWarnings("unchecked")
	public List<Pessoa> buscarContatos() {
		return fabrica.createQuery("from Pessoa").getResultList();
	
	}


	public Pessoa pessoaPorID(Long id){
		return fabrica.find(Pessoa.class, id);
		
	}

}
