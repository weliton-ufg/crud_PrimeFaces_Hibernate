package com.weliton.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.weliton.Dao.PessoaDao;
import com.weliton.Modelo.Pessoa;
import com.weliton.Util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Pessoa.class)
public class ConrversorPessoa implements Converter {
	
	//@Inject
	private PessoaDao pessoaDao;
	
	
	public ConrversorPessoa() {
		pessoaDao=CDIServiceLocator.getBean(PessoaDao.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent componente, String valor) {
		Pessoa retorno=null;
		if(valor!=null){
			Long id= new Long(valor);
			retorno=pessoaDao.pessoaPorID(id);
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent componente, Object valor) {
		if(valor!=null){
			Pessoa pessoa=(Pessoa) valor;
			return pessoa.getId()==null ?null : pessoa.getId().toString();
		
		}
		
		return "";
	}

}
