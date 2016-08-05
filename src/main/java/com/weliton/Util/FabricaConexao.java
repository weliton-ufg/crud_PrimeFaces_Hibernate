package com.weliton.Util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class FabricaConexao {
	private EntityManagerFactory fabrica;
	
	public FabricaConexao(){
		fabrica=Persistence.createEntityManagerFactory("crud_Jsf_PrimeFaces_Jpa_HibernatePU");
	}
	@Produces @RequestScoped
	public EntityManager conexão(){
		System.out.println("conectado");
		return fabrica.createEntityManager();
		
	}
	public void fecharConexão(@Disposes EntityManager fabrica){
		fabrica.close();
		System.out.println("Conexão fechada");
	}
}
