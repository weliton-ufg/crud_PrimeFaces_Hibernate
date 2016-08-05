package com.weliton.Modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SalvandoObjeto {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("crud_Jsf_PrimeFaces_Jpa_HibernatePU");
		EntityManager em = emf.createEntityManager();

		Pessoa pessoa = new Pessoa();
		// PessoaDao pD = new PessoaDao();
		pessoa.setNome("Weliton");
		pessoa.setApelido("Lima");
		pessoa.setTelefone("(62)93436492");
		pessoa.setEmail("weliton@gmail.com");
		// pD.salvar(pessoa);
		em.getTransaction().begin();
		System.out.println("incio");
		em.persist(pessoa);
		System.out.println("meio");
		em.getTransaction().commit();
		System.out.println("fim");
		em.close();

	}
}
