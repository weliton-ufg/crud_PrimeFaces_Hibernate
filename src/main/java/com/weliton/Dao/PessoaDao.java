package com.weliton.Dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.weliton.Modelo.Pessoa;

public class PessoaDao {
	@Inject
	private EntityManager fabrica;
	
	public Pessoa adicionar(Pessoa pessoa){
		EntityTransaction trx= fabrica.getTransaction(); 
		trx.begin();
			fabrica.merge(pessoa);
		trx.commit();
		
		return pessoa;
		
	}

}
