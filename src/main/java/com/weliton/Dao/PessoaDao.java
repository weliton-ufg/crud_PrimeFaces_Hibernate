package com.weliton.Dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.weliton.Modelo.Pessoa;
import com.weliton.Util.FabricaConexao;

public class PessoaDao {
	@Inject
	private EntityManager fabrica;
	
	public Pessoa adicionar(Pessoa pessoa){
		EntityTransaction trx= fabrica.getTransaction(); 
		trx.begin();
		
		trx.commit();
		return pessoa;
		
	}

}
