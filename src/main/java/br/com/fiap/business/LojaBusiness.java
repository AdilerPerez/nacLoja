package br.com.fiap.business;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.fiap.exception.ResponseBusinessException;
import br.com.fiap.model.LojaModel;

@Component
public class LojaBusiness {

	@Value("${rest.exception.business.containsHttps}")
	private String containsHttps; 
	
	
	public LojaModel applyBusiness(LojaModel loja) throws ResponseBusinessException{
	
		String urlLowerCase = changeUrlToLowerCase(loja.getUrl());
		loja.setUrl(urlLowerCase);
		
		verifyHttpHttps(loja.getUrl());
		return loja;
	}

	private String changeUrlToLowerCase(String url) {
		return url.toLowerCase();
	}
	
	private void verifyHttpHttps(String url) throws ResponseBusinessException {
		String nomeUrl = url.toLowerCase();
			
		if(!nomeUrl.startsWith("http://") && !nomeUrl.startsWith("https://"))
			throw new ResponseBusinessException(containsHttps);
	}
}
