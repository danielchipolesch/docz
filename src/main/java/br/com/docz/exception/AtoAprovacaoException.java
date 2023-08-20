package br.com.docz.exception;

import br.com.docz.helper.ExceptionHelper;

public class AtoAprovacaoException implements ExceptionHelper{
	
	private static final String ATO_APROVACAO_NAO_ENCONTRADO = " não encontrado";
	private static final String CAMPO_NAO_NULO = " não pode(m) ser nulo(s)";
	private static final String PARAMETRO_NAO_NULO = "Parâmetro não pode ser nulo";
	
	public static String objectNotFound(String param){
		return param + ATO_APROVACAO_NAO_ENCONTRADO;
	}
	
	public static String fieldNotNull(String param){
		return param + CAMPO_NAO_NULO;
	}
	
	public static String parameterNotNull(){
		return PARAMETRO_NAO_NULO;
	}

}
