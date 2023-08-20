package br.com.docz.exception;

import br.com.docz.helper.ExceptionHelper;

public class SumarioException implements ExceptionHelper{
	
	private static final String SUMARIO_NAO_ENCONTRADO = " não encontrado";
	private static final String CAMPO_NAO_NULO = " não pode(m) ser nulo(s)";
	private static final String PARAMETRO_NAO_NULO = "Parâmetro não pode ser nulo";
	
	public static String objectNotFound(String param){
		return param + SUMARIO_NAO_ENCONTRADO;
	}
	
	public static String fieldNotNull(String param){
		return param + CAMPO_NAO_NULO;
	}
	
	public static String parameterNotNull(){
		return PARAMETRO_NAO_NULO;
	}

}
